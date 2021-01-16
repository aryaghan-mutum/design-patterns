package com.designpatterns.builder;

import org.junit.Test;

class ShipTest {

    @Test
    public static void shipTest() {
        Ship ship1 = new ShipBuilder()
                .buildShipName("AL") //..
                .buildShipLength(343) //..
                .buildShipCapacity(4000) //intermediate operators
                .buildShip(); //terminal operation
    }

    @Test
    public static void shipTest2() {
        Ship ship1 = new ShipBuilder()
                .with(ship -> ship.buildShipName("AD"))
                .buildShipLength(432)
                .buildShipCapacity(3000)
                .buildShip();
    }
}
