package pkgfinal;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class FlightpassengersController {

    @FXML
    private TextArea passengerList;
  
    String flightNumber;

    public void setFlight(String entry){
        flightNumber = entry;
    }
    
    @FXML
    public void initialize() {
        
        passengerList.setText("");
        
        
        try (Scanner input = new Scanner(Paths.get(flightNumber + "passengers.txt"))) {
            
            
            while (input.hasNext()) {
                reservation passenger = new reservation();
                passenger.setFirst(input.next());
                passenger.setLast(input.next());
                String ID = input.next();
                passenger.setSeat(input.next());
                String output = passenger.getFirst() + "      " + passenger.getLast() + "      " + ID + "      " + passenger.getSeat() + "      ";
                passengerList.appendText(output);
                passengerList.appendText("\n");
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }

    }
}
