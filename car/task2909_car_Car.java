package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;



    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;
    private boolean canPassengersBeTransferred(){
        if (isDriverAvailable() & fuel > 0){
            return true;
        } else {
            return false;
        }
    }


    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
        if (type==0)
            return new Truck(numberOfPassengers);
        else if (type==1)
            return new Sedan(numberOfPassengers);
        else if (type==2)
            return new Cabriolet(numberOfPassengers);
        else return null;

    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd){
        return date.before(summerEnd) && date.after(summerStart);
    }

    public double getWinterConsumption(int length){
        return (winterFuelConsumption*length)+winterWarmingUp;
    }
    public double getSummerConsumption(int length){
        return (summerFuelConsumption*length);
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        if (isSummer(date, summerStart, summerEnd))
        {
            return getSummerConsumption(length);
        } else
            return getWinterConsumption(length);
    }


    public int getNumberOfPassengersCanBeTransferred() {
        if (true) {}
        return canPassengersBeTransferred()?numberOfPassengers:0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (getNumberOfPassengersCanBeTransferred() > 0){
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {

    }

    public void fastenDriverBelt() {

    }


    public abstract int getMaxSpeed();

}
