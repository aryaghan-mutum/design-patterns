package com.designpatterns.builder;


import java.util.function.Consumer;

class ShipBuilder {

    private String shipName;
    private double length;
    private int capacity;

    public ShipBuilder buildShipName(String shipName) {
        this.shipName = shipName; //set
        return this;
    }

    public ShipBuilder buildShipLength(double length) {
        this.length = length; //set
        return this;
    }

    public ShipBuilder buildShipCapacity(int capacity) {
        this.capacity = capacity; //set
        return this;
    }

    public Ship buildShip() {
        return new Ship(shipName, length, capacity);
    }

    //using Consumer function interface:
    public ShipBuilder with(Consumer<ShipBuilder> function)  {
        function.accept(this);
        return this;
    }
}

