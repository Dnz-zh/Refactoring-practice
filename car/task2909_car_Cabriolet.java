package com.javarush.task.task29.task2909.car;

public class Cabriolet extends Car {

    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    final int MAX_TRUCK_SPEED  = 90;

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
