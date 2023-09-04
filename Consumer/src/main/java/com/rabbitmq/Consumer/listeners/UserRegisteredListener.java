package com.rabbitmq.Consumer.listeners;

import com.rabbitmq.Consumer.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class UserRegisteredListener {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public UserRegisteredListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "user_registration")
    public void onMessageReceived(String mesage){
        System.out.println("Got message from producer: " + mesage);

        rabbitTemplate.convertAndSend(RabbitMQConfig.RESPONSE_QUEUE, "Successful!");
    }
}
