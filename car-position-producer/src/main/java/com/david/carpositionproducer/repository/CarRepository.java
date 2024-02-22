package com.david.carpositionproducer.repository;

import com.david.carpositionproducer.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    Car findByName(String name);
}
