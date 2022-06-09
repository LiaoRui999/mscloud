package com.liaorui.springcloud.service;

import com.liaorui.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiaoRui
 * @create 2022-05-19 23:43
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
