package com.rabbitmq.Consumer.config;

import com.rabbitmq.Consumer.listeners.UserRegisteredListener;
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
//        container.setQueueNames(REGISTRATION_QUEUE);
//        container.setMessageListener(listenerAdapter);
        return container;
    }

//    @Bean
//    MessageListenerAdapter listenerAdapter(UserRegisteredListener listener){
//        return new MessageListenerAdapter(listener, "onMessageReceived");
//    }
}
