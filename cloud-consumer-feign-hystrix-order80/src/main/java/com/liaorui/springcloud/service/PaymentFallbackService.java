package com.liaorui.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author LiaoRui
 * @create 2022-06-08 11:48
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80---paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80---paymentInfo_TimeOut";
    }
}
