package com.booleanuk.core;

public class Game implements Item{
    String name;
    int price;

    public Game(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}
