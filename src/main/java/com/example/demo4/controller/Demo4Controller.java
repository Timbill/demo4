package com.example.demo4.controller;

//import com.example.demo4.persistance.CarRepository;
import com.example.demo4.persistance.CarRepository;
import com.example.demo4.service.Demo4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo4.exception.CarNotFoundException;
import com.example.demo4.model.Car;

import java.util.Arrays;
import java.util.List;

@RestController public class Demo4Controller {

    @Autowired CarRepository carRepository;

    @Autowired
    Demo4Service demo4Service;


    @GetMapping(path = "/hello", produces = "application/json") public String getHelloMessage () {
        return "Hello there from Demo4Controller";
    }

    @GetMapping(path = "/car/{model}", produces = "application/json") public Car getCar (@PathVariable("model") String model) {
        {
            return demo4Service.getCarInfo(model);

        }
    }

    @GetMapping(path = "/car", produces = "application/json") public Iterable <Car> getCars () {
        {

            Iterable <Car> cars = demo4Service.getCarsInfo();

            return cars;

        }
    }

    @PostMapping(path = "/setCar", produces = "application/json") public Car setCar (@RequestBody Car car) {
        {

            return demo4Service.setCarInfo(car);

        }
    }

    @PostMapping(path = "/updateCar", produces = "application/json") public Car updateCar (@RequestBody Car car) {
        {

            return demo4Service.updateCarInfo(car);

        }
    }
}

