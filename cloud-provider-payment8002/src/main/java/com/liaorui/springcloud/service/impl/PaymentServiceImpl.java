package com.liaorui.springcloud.service.impl;

import com.liaorui.springcloud.dao.PaymentDao;
import com.liaorui.springcloud.entities.Payment;
import com.liaorui.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LiaoRui
 * @create 2022-05-19 23:44
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
