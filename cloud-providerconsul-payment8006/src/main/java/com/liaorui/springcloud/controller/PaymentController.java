package com.liaorui.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author LiaoRui
 * @create 2022-05-30 17:47
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String PaymentInfo() {
        return "springcloud with consul:" + serverPort + "\t\t" + UUID.randomUUID().toString();
    }
}
