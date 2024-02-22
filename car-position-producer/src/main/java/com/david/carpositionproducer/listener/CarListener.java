package com.david.carpositionproducer.listener;

import com.david.carlibrary.domain.Car;
import com.david.carlibrary.repository.CarRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CarListener {

    public static final String TOPIC = "cars";
    public static final Logger logger = LoggerFactory.getLogger(CarListener.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CarRepository carRepository;

    @KafkaListener(topics = TOPIC)
    public void listen(@Payload String message) {
        logger.info("Received message: {} ", message);
        try {
            Car car = objectMapper.readValue(message, Car.class);
            carRepository.save(car);
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Cannot parse string to object: {}", message);
        }
    }
}
