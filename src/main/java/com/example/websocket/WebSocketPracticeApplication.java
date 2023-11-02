package com.example.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WebSocketPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketPracticeApplication.class, args);
    }

}
