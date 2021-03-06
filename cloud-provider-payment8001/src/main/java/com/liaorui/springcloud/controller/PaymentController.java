package com.liaorui.springcloud.controller;

import com.liaorui.springcloud.entities.CommonResult;
import com.liaorui.springcloud.entities.Payment;
import com.liaorui.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author LiaoRui
 * @create 2022-05-19 23:47
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "payment/create")
    public CommonResult creat(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入数据" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,服务端口号为：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查询数据" + payment + "哈哈哈111***");
        if (payment != null) {
            return new CommonResult(200, "查询数据成功服务端口号为：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录" + ",查询ID=" + id, null);
        }

    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("*****element:" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        System.out.println("*****paymentFeignTimeOut from port: " + serverPort);
        //暂停3秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
