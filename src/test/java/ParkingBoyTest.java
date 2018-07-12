import com.thoughtworks.tdd.Car;
import com.thoughtworks.tdd.ParkingLot;
import com.thoughtworks.tdd.ParkingLotException;
import com.thoughtworks.tdd.Receipt;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ParkingBoyTest {
    @Test
    public void should_park_successfully_given_parking_lot_is_not_full(){
        ParkingLot parkingLot1 = new ParkingLot(1);
        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(parkingLot1);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);
        try {
            parkingBoy.parking(new Car());
        }catch (ParkingLotException exception){
            fail("should park successfully");
        }
    }

    @Test
    public void should_get_specific_car_when_call_Pick_given_receipt_is_right(){
        ParkingLot parkingLot1 = new ParkingLot(1);
        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(parkingLot1);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);
        Car theCar = new Car();
        Receipt receipt = parkingBoy.parking(theCar);
         assertThat(parkingBoy.pickCar(receipt),is(theCar));

    }

    @Test
    public void should_park_successfully_given_two_parking_lots(){
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(parkingLot1);
        ParkingLotList.add(parkingLot2);
        ParkingBoy parkingBoy =new ParkingBoy(ParkingLotList);
        try {
            parkingBoy.parking(new Car());
        }catch (ParkingLotException exception){
            fail("should park successfully");
        }
    }
    @Test
    public void should_get_specific_car_when_given_two_parking_lots(){
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(parkingLot1);
        ParkingLotList.add(parkingLot2);
        ParkingBoy parkingBoy =new ParkingBoy(ParkingLotList);
        Car theCar = new Car();
        Receipt receipt = parkingBoy.parking(theCar);
        assertThat(parkingBoy.pickCar(receipt),is(theCar));
    }
    @Test
    public void should_park_by_order_when_given_two_parking_lots(){
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(parkingLot1);
        ParkingLotList.add(parkingLot2);
        ParkingBoy parkingBoy =new ParkingBoy(ParkingLotList);
        Car theCar = new Car();
        Receipt receipt1 = parkingBoy.parking(theCar);
        System.out.print(receipt1);
        assertThat(parkingBoy.pickCar(receipt1),is(parkingLot1.unPack(receipt1)));
    }

    @Test
    public void should_not_get_specific_car_when_call_unPark_given_receipt_is_wrong(){
        ParkingLot parkingLot1 = new ParkingLot(2);
        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(parkingLot1);
        ParkingBoy parkingBoy =new ParkingBoy(ParkingLotList);
        Car theCar =new Car();
        Receipt receipt = parkingBoy.parking(theCar);
        Receipt anotherReceipt = parkingBoy.parking(new Car());
        assertThat(parkingBoy.pickCar(anotherReceipt),not(theCar));
    }


}
