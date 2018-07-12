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
        //this.size++;
        Car car = carReceipt.get(receipt);
        carReceipt.remove(receipt);
//        System.out.print("&&"+carReceipt.get(receipt));
//        System.out.print("&&"+carReceipt.remove(receipt));
        return car;

    }

    public boolean isFull() {
        return carReceipt.size() == size;
    }


}
