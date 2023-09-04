package com.rabbitmq.Producer.config;

import com.rabbitmq.Producer.listeners.ResponseListener;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static String REGISTRATION_QUEUE = "user_registration";
    public static String RESPONSE_QUEUE = "response";

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
//        container.setMessageListener(listenerAdapter);
//        container.setQueueNames(RESPONSE_QUEUE);
        return container;
    }

//    @Bean
//    MessageListenerAdapter listenerAdapter(ResponseListener listener){
//        return new MessageListenerAdapter(listener, "onMessageReceived");
//    }
}
