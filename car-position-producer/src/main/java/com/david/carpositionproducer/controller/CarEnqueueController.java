package com.david.carpositionproducer.controller;

import com.david.carlibrary.domain.Car;
import com.david.carlibrary.repository.CarRepository;
import com.david.carpositionproducer.producer.CarProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/car")
public class CarEnqueueController {

    @Autowired
    private CarProducerService carProducerService;

    @Autowired
    private CarRepository carRepository;

    @PostMapping("enqueue")
    public void saveCar(@RequestBody Car car) {
        carProducerService.enqueueCar(car);
    }
}
