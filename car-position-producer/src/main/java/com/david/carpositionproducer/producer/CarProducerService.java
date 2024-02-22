package com.david.carpositionproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CarProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static final String TOPIC = "cars";
    public static final Logger logger = LoggerFactory.getLogger(CarProducerService.class);

    public void enqueueCar(String data) {
        try {
            kafkaTemplate.send(TOPIC, data);
            logger.info("Sent message :{} to kafka topic: {}", data, TOPIC);
        } catch (Exception e) {
            logger.error("Cannot enqueue data {} to topic cars: ", data);
        }
    }
}
