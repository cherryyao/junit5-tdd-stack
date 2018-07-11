package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingTest {

    @Test
    public void should_return_carid_sucessful_when_input_carid(){

        Car car = new Car("123456");
        String result = car.getCariId(car);
        assertThat(result,is("123456"));
    }

    @Test
    public void should_return_appendcar_sucessful_when_input_car(){

        Car car = new Car("123456");
        Parking parking =new Parking();

        String result = parking.appendID(car);
        assertThat(result,is("123456"));
    }



}
