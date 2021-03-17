package com.griddynamics.services.rabbit.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.griddynamics.services.rabbit.commons.message.Message;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@Slf4j
@EnableScheduling
@RequiredArgsConstructor
public class Sender {

    public static final int MESSAGE_COUNT = 10;
    @Value("${sender.exchange}")
    private String exchange;
    @Value("${sender.routingKey}")
    private String routingKey;

    private final RabbitTemplate template;
    private final AtomicInteger MESSAGE_ID = new AtomicInteger(0);

    public static void main(String[] args) {
        SpringApplication.run(Sender.class, args);
    }

    @Scheduled(fixedDelay = 1000)
    public void send() {
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String payload = "Payload #" + System.currentTimeMillis();
            Message message = new Message(MESSAGE_ID.incrementAndGet(), payload);
            template.convertAndSend(exchange, routingKey, message);
            log.info("Sending routingKey={} message={}", exchange, message);
        }
    }
}
