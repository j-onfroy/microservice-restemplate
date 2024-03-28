package com.company.notification.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRabbitListener {

    @RabbitListener(queues = {"employee-queue"})
    public void listen(Message message) {
        System.out.println(message);
    }

    @RabbitListener(queues = {"employee-shipping"})
    public void listen2(Message message) {
        System.out.println("---------");
        System.out.println(message);
    }
}
