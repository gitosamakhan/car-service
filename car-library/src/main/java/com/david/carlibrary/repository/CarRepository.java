package com.david.carlibrary.repository;

import com.david.carlibrary.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    Car findByName(String name);
}
