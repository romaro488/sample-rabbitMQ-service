package com.griddynamics.services.rabbit.listener;

import com.griddynamics.services.rabbit.commons.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
@Slf4j
public class Listener {

    public static void main(String[] args) {
        SpringApplication.run(Listener.class, args);
    }

    @RabbitListener(queues = "${listener.queue}")
    public void onMessage(Message message) {
        log.info("Received message={}", message);
    }
}
