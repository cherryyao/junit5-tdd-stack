package com.thoughtworks.tdd;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    int size;
    private Map<Receipt,Car> carReceipt = new HashMap<>();


    public ParkingLot(int size) {
        this.size = size;
    }

    public Receipt park(Car theCar) {
       Receipt receipt = new Receipt();
       carReceipt.put(receipt,theCar);
        return receipt;
    }

    public Car unPack(Receipt receipt) {
        this.size--;
        return carReceipt.remove(receipt);

    }

    public boolean isFull() {
        return this.size == 0;
    }


}
