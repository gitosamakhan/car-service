package com.david.carpositionproducer.controller;

import com.david.carpositionproducer.producer.CarProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CarController {

    @Autowired
    private CarProducerService carProducerService;

    @GetMapping("enqueue")
    public String enqueueCar() {
        carProducerService.enqueueCar("cars here baby");
        return "Sent";
    }
}
