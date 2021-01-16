package com.designpatterns.builder;

import com.designpatterns.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ShipTest extends BaseTest {

    @Test
    public void testShipWithBuilderPattern() {
        Ship ship = new ShipBuilder()
                .buildShipName("AL")
                .buildShipLength(343)
                .buildShipCapacity(4000)
                .buildShip();

        soft.assertThat(ship.getCapacity()).isEqualTo(4000);
        soft.assertThat(ship.getShipName()).isEqualTo("AL");
        soft.assertThat(ship.getLength()).isEqualTo(343);
    }

    @Test
    public void testShipWithoutBuilderPattern() {
        Ship ship = new ShipBuilder().buildShip();
        ship.setShipName("AD");
        ship.setCapacity(5000);
        ship.setLength(376);
        soft.assertThat(ship.getCapacity()).isEqualTo(5000);
        soft.assertThat(ship.getShipName()).isEqualTo("AD");
        soft.assertThat(ship.getLength()).isEqualTo(376);
    }
}
