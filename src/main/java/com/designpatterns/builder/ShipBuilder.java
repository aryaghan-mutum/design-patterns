package com.designpatterns.builder;

import java.util.function.Consumer;

class ShipBuilder {

    private String shipName;
    private double length;
    private int capacity;

    public ShipBuilder buildShipName(String shipName) {
        this.shipName = shipName;
        return this;
    }

    public ShipBuilder buildShipLength(double length) {
        this.length = length;
        return this;
    }

    public ShipBuilder buildShipCapacity(int capacity) {
        this.capacity = capacity;
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

