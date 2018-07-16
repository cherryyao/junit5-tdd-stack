import controller.ParkingboyController;
import model.ParkingBoy;
import model.ParkingLot;
import view.Cli;
import view.Request;
import view.Response;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args){
        Request request = new Request();
        Response response = new Response();

        ParkingLot parkingLot1 =new ParkingLot(1);
        ParkingLot parkingLot2 =new ParkingLot(1);
        List<ParkingLot> ParkingLotList = new ArrayList<>();
        ParkingLotList.add(parkingLot1);
        ParkingLotList.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);
        ParkingboyController controller =new ParkingboyController(parkingBoy);
        Router router = new Router("main",controller);

        Cli cli = new Cli();
        router.printMainInterface();

        while(true){
            String readCommand = cli.read();
            request.setParameter(readCommand);
            router.handleRequest(request);

        }
    }
}
