package com.david.carpositionproducer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CarListener {

    public static final String TOPIC = "cars";
    public static final Logger logger = LoggerFactory.getLogger(CarListener.class);

    @KafkaListener(topics = TOPIC)
    public void listen(@Payload String message) {
        logger.info("Received message: {} ", message);
        System.out.println("Received message: " + message);
    }
}
