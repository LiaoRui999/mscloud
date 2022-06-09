package com.liaorui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LiaoRui
 * @create 2022-05-24 12:30
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
public class orderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(orderMain80.class, args);
    }
}
