package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {
    private static int nextId = 0;
    private int id;
    protected boolean isSoldier;


    public Soldier(String name, int age) {
        super(name, age);

    }

    public Soldier(boolean isSoldier) {
        this.isSoldier = isSoldier;
        this.id = nextId;
        nextId++;
    }

    public void fight() {
    }

    public void live() {
        if (!isSoldier)
            this.fight();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
