package com.rabbitmq.Producer.listeners;

import com.rabbitmq.Producer.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class ResponseListener {
    @RabbitListener(queues = "response")
    public void onMessageReceived(String message){
        System.out.println("Got response from consumer: " + message);
    }
}
