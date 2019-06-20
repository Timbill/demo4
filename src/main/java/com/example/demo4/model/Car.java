package com.example.demo4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // fields
    private String type;
    private String model;
    private String color;
    private int speed;

    public long getId () {
        return this.id;
    }

    public void setId (final long id) {
        this.id = id;
    }

    public String getType () {
        return this.type;
    }

    public void setType (final String type) {
        this.type = type;
    }

    public String getModel () {
        return this.model;
    }

    public void setModel (final String model) {
        this.model = model;
    }

    public String getColor () {
        return this.color;
    }

    public void setColor (final String color) {
        this.color = color;
    }

    public int getSpeed () {
        return this.speed;
    }

    public void setSpeed (final int speed) {
        this.speed = speed;
    }

    // constructor
    public Car() {

    }

    public Car(String type, String model, String color) {
        this.type = type;
        this.model = model;
        this.color = color;
    }

    // methods
    int increaseSpeed(int increment) {
        this.speed = this.speed + increment;
        return this.speed;
    }

    // ...
}
