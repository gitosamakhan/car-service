package com.david.carwebservice.controller;

import com.david.carlibrary.domain.Car;
import com.david.carlibrary.repository.CarRepository;
import com.david.carwebservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping()
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getStudent(@PathVariable("id") String id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find resource with id:" + id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCar(@RequestBody Car car) {
        carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") String id) {
        carRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCar(@RequestBody Car updatedCar, @PathVariable("id") String id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setName(updatedCar.getName());
            carRepository.save(car);
        }
    }
}
