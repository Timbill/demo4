package com.example.demo4.persistance;

import java.util.List;

import com.example.demo4.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
//    List<Car> findByModel(String model);
    Car findByModel(String model);

}
