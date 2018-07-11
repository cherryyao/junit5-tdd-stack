package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ParkingLotTest {

    @Test
    public void should_park_successfully_given_parking_lot_is_not_full(){
        ParkingLot parkingLot = new ParkingLot(1);
        try {
            parkingLot.park(new Car());
        }catch (ParkingLotException exception){
            fail("should park successfully");
        }
    }

    @Test
    public void should_park_failed_given_parking_lot_is_full(){
        ParkingLot parkingLot = new ParkingLot(0);
        try {
            parkingLot.park(new Car());
            fail("should park successfully");
        }catch (Error e){
        }
    }

    @Test
    public void should_get_specific_car_when_call_unPark_given_receipt_is_right(){
        ParkingLot parkingLot = new ParkingLot(1);

        Car theCar =new Car();
        Receipt receipt = parkingLot.park(theCar);
        assertThat(parkingLot.unPack(receipt),is(theCar));
    }

    @Test
    public void should_not_get_specific_car_when_call_unPark_given_receipt_is_false(){

    }


}
