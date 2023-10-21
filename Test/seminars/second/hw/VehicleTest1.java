package seminars.second.hw;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.seminars.second.hw.Car;
import org.seminars.second.hw.Motorcycle;
import org.seminars.second.hw.Vehicle;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


class VehicleTest1 {
    Car car;
    Motorcycle motorcycle;


    @BeforeEach
    void setUp(){
        car = new Car("Hyundai", "Tucson", 2018);
        motorcycle = new Motorcycle("Suzuki","GSX-R 750", 2007);
    }
    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testCarHasFourWheels() {
        assertThat(car.getNumWheels(), is(4));

    }

    @Test
    public void testMotorcycleHasTwoWheels() {
        assertThat(motorcycle.getNumWheels(), is(2));
    }

    @Test
    public void testCarSpeedInTestDriveMode() {
        car.testDrive();
        assertThat(car.getSpeed(), is(60));
    }

    @Test
    public void testMotorcycleSpeedInTestDriveMode() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed(), is(75));
    }

    @Test
    public void testCarSpeedAfterParking() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed(), is(0));
    }

    @Test
    public void testMotorcycleSpeedAfterParking() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed(), is(0));
    }
}
