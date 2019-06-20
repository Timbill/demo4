package com.example.demo4.service;

import com.example.demo4.exception.CarNotFoundException;
import com.example.demo4.model.Car;
import com.example.demo4.persistance.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Collection;

@Service
public class Demo4Service {

    @Autowired
    CarRepository carRepository;

    public Car getCarInfo(String model) {
        Car car = carRepository.findByModel(model);
        System.out.println("Car model is " + car.getModel());
        System.out.println("Car colour is " + car.getColor());
        return car;
    }

    public Iterable<Car>  getCarsInfo() {
        Iterable<Car> cars = carRepository.findAll();
     //   List<Car> carsList = iterableToCollection(cars);
        //System.out.println("Car model is " + car.getModel());
        //System.out.println("Car colour is " + car.getColor());
        return cars;
    }
    public Car setCarInfo(Car car) {
        System.out.println("Car speed  is " + car.getSpeed());
        if(car.getSpeed() == (150))throw new CarNotFoundException();

        System.out.println("Car colour is " + car.getModel());
        System.out.println("Car colour is " + car.getColor());
        System.out.println("Car speed  is " + car.getSpeed());

        carRepository.save(car);
        return car;
    }
}
