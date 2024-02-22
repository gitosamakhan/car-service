package com.david.carpositionproducer.controller;

import com.david.carpositionproducer.domain.Car;
import com.david.carpositionproducer.producer.CarProducerService;
import com.david.carpositionproducer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CarController {

    @Autowired
    private CarProducerService carProducerService;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/car")
    public List<Car> enqueueCar() {
        return carRepository.findAll();
    }

    @PostMapping("/car")
    public void saveCar(@RequestBody Car car) {
        carProducerService.enqueueCar(car);
    }
}
