package pkgfinal;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


    public class ReservationspageController extends Final{

    @FXML
    private TextArea resPage;
    
    private ArrayList<reservation> allRes = new ArrayList<>();
    
    @FXML
        public void initialize() {
    
    resPage.setText("");
            
    try (Scanner input = new Scanner(Paths.get("reservations.txt"))) {

            while (input.hasNext()) {
                reservation res = new reservation();
                res.setFlightNumber(input.next());
                res.setFirst(input.next());
                res.setLast(input.next());
                res.setiD(input.next());
                res.setSeat(input.next());
                String output = res.getFlightNumber() + "      " + res.getFirst() + "      " + res.getLast() + "      " + res.getiD() + "      " + res.getSeat() + "      ";
                resPage.appendText(output);
                resPage.appendText("\n");
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }
    
    }
        
    //compiles list of flight numbes
    //for use in NewResController
    public void setflightNumbers(ArrayList<reservation> codes) {
        allRes = codes;
    }
    
}
