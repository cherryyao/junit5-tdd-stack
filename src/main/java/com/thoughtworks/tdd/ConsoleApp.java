package com.thoughtworks.tdd;

import java.util.Scanner;
import java.util.UUID;

public class ConsoleApp {

    private ParkingBoy parkingBoy;

    public static void main(String[] args){
        ConsoleApp consoleApp = new ConsoleApp();
        //consoleApp.init();
        consoleApp.start();
    }


    public void start(){
        output("1.停车\n"+"2.取车\n"+"请输入您要进行的操作:");
        String action = readInput();
        if (action == "1"){
            output("请输入车牌号:");
            String inputs = readInput();
            try{
                UUID uuid = park(inputs);
            }catch (ParkingLotFullException e){
                output("车已停满，请晚点再来");
            }
        }



    }

    private UUID park(String inputs) {
        if(parkingBoy.isParking()){
            Car car = new Car(inputs);
            Receipt receipt = parkingBoy.parking(car);
            return receipt.getUUID();
        }else{
            throw new ParkingLotFullException();
        }
    }

    private String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public String output(String message){
        System.out.print(message);
        return message;
    }
}
