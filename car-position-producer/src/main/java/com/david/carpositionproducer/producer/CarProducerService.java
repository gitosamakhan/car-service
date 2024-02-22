package com.david.carpositionproducer.producer;

import com.david.carpositionproducer.domain.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CarProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public static final String TOPIC = "cars";
    public static final Logger logger = LoggerFactory.getLogger(CarProducerService.class);

    public void enqueueCar(Car car) {
        try {
            String data = objectMapper.writeValueAsString(car);
            kafkaTemplate.send(TOPIC, data);
            logger.info("Sent message :{} to kafka topic: {}", data, TOPIC);
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Cannot parse object: {}", car);
        } catch (Exception e) {
            logger.error("Cannot enqueue data {} to topic cars: ", car);
        }

    }
}
