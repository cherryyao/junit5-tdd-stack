package com.thoughtworks.tdd;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Receipt,Car> carReceipt = new HashMap<>();
    public ParkingLot(int size) {
    }

    public Receipt park(Car theCar) {
       Receipt receipt = new Receipt();
       carReceipt.put(receipt,theCar);
        return receipt;
    }

    public Car unPack(Receipt receipt) {
        return carReceipt.get(receipt);
    }
}
