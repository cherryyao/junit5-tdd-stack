package controller;

import com.thoughtworks.tdd.*;

import java.util.UUID;

public class ParkingboyController {
   private ParkingBoy parkingBoy;



    public ParkingboyController(model.ParkingBoy parkingBoy) {
    }

    public void showMainPage(){
    }

    public UUID park(String inputs) {
        if(parkingBoy.isParking()){
            Car car = new Car(inputs);
            Receipt receipt = parkingBoy.parking(car);
            return receipt.getUUID();
        }else{
            throw new ParkingLotFullException();
        }
    }

    public String unPark(String  inputRecipit) {
        try{
            Receipt receipt = new Receipt(UUID.fromString(inputRecipit));
            Car car = parkingBoy.pickCar(receipt);
            return car.getId();
        }catch (Exception e){
            throw new UnparkExcepiton();
        }
    }

    public boolean isFull(){
        return parkingBoy.isParking();
    }
}
