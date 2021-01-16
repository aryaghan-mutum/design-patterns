package com.designpatterns.builder;

import lombok.Data;

@Data
public class Ship {

    private String shipName;
    private double length;
    private int capacity;

    public Ship(String shipName, double length, int capacity) {
        this.shipName = shipName;
        this.length = length;
        this.capacity = capacity;
    }
}



