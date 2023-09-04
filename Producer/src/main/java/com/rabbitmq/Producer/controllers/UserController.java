package com.rabbitmq.Producer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.Producer.config.RabbitMQConfig;
import com.rabbitmq.Producer.dto.RegisterUserDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class UserController implements ApplicationContextAware {
    private final RabbitTemplate rabbitTemplate;

    ApplicationContext applicationContext;

    @Autowired
    public UserController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterUserDTO registerUserDTO) throws JsonProcessingException {

        rabbitTemplate.convertAndSend(RabbitMQConfig.REGISTRATION_QUEUE, new ObjectMapper().writeValueAsString(registerUserDTO));

        Map<String, String> response = new HashMap<>();
        response.put("message", "User Registered!");

        return ResponseEntity.ok(response);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
