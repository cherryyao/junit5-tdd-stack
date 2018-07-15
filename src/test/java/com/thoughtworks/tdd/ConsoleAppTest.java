package com.thoughtworks.tdd;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;


public class ConsoleAppTest {
    ConsoleApp consoleApp = new ConsoleApp();

    @Test
    public void should_park_successfully_when_action_is_parking(){
        try {
            consoleApp.initParkingLot();
            consoleApp.park("C123456");
        }catch (ParkingLotFullException e){
            System.out.print("车已停满，请晚点再来");
        }
    }

    @Test
    public void should_park_unsuccessfully_when_action_is_parking(){
        try {
            ArrayList<ParkingLot> parkingLots = new ArrayList<>();
            parkingLots.add(new ParkingLot(0));
            ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
            consoleApp.park("C123456");
            fail("车已停满，请晚点再来");
        }catch (Exception e){
        }
    }


}
