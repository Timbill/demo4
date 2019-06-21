package com.example.demo4.service;

import org.springframework.cache.annotation.Cacheable;
import com.example.demo4.exception.CarNotFoundException;
import com.example.demo4.model.Car;
import com.example.demo4.persistance.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Demo4Service {

    @Autowired
    CarRepository carRepository;

//    @Cacheable("getCar")
    public Car getCarInfo(String model) {

        Car car = carRepository.findByModel(model);
        System.out.println("getCarInfo-Car model is " + car.getModel());
        System.out.println("getCarInfo-Car colour is " + car.getColor());
        return car;
    }

//    @Cacheable("getCars")
    public Iterable<Car>  getCarsInfo() {

        Iterable<Car> cars = carRepository.findAll();

        return cars;
    }
    public Car setCarInfo(Car car) {

        System.out.println("setCarInfo-Car speed  is " + car.getSpeed());
        if(car.getSpeed() == (150))throw new CarNotFoundException();

        System.out.println("setCarInfo-Car model is " + car.getModel());
        System.out.println("setCarInfo-Car colour is " + car.getColor());
        System.out.println("setCarInfo-Car speed  is " + car.getSpeed());

        carRepository.save(car);
        return car;
    }
    public Car updateCarInfo(Car car) {

        System.out.println("changeCarInfo-Car speed  is " + car.getSpeed());
        if(car.getSpeed() == (150))throw new CarNotFoundException();

        Car carPersisted = carRepository.findByModel(car.getModel());
        System.out.println("changeCarInfo-Car model is " + car.getModel());
        System.out.println("changeCarInfo-Car colour is " + car.getColor());
        System.out.println("changeCarInfo-Car speed  is " + car.getSpeed());
        carPersisted.setModel(car.getModel());
        carPersisted.setSpeed(car.getSpeed());
        carPersisted.setModel(car.getModel());
        carPersisted.setType(car.getType());

        carRepository.save(carPersisted);
        return car;
    }
}
