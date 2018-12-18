package pkgfinal;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class SeatMapController {

    @FXML
    private TextArea seatChart;
  
    String flightNumber;

    public void setChart(String entry){
        flightNumber = entry;
    }
    
    @FXML
    public void initialize() {
        
        seatChart.setText("");
        
        
        try (Scanner input = new Scanner(Paths.get(flightNumber + ".txt"))) {
            
            
            while (input.hasNext()) {
                
                for(int i = 0; i < 8; i++){
                String seatNumber = input.next() + "    ";
                seatChart.appendText(seatNumber);
                }
                seatChart.appendText("\n");
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }

    }
}
