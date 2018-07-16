package com.thoughtworks.tdd;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {

    int size;
    private Map<UUID,Car> carReceipt = new HashMap<>();


    public ParkingLot(int size) {
        this.size = size;
    }

    public Receipt park(Car theCar) {
       if (isFull()) {
           throw new ParkingLotFullException();
       }else
       {
           Receipt receipt = new Receipt();
           UUID uuid = UUID.randomUUID();
           receipt.setUuid(uuid);
           carReceipt.put(receipt.getUUID(),theCar);
           return receipt;
       }

    }

    public Car unPack(Receipt receipt) {
        if (carReceipt.containsKey(receipt.getUUID())){
            Car car = carReceipt.get(receipt.getUUID());
            carReceipt.remove(receipt.getUUID());
            return car;
        }else {
            throw new UnparkExcepiton();
        }


    }

    public boolean isFull() {
        return carReceipt.size() == size;
    }


}
