package pkgfinal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class NewResController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField idNumber;

    @FXML
    private Button chooseSeat;

    @FXML
    private Button createRes;

    @FXML
    private FXMLDocumentController myFXML;

    public static ArrayList<reservation> allRes = new ArrayList<>();
    private String seatSelection = "2B";

    @FXML
    void chooseSeat(ActionEvent event) {
        try {
            FXMLLoader seatingpage = new FXMLLoader(getClass().getResource("seatingpage.fxml"));
            Parent root = (Parent) seatingpage.load();
            SeatingpageController file = seatingpage.getController();
            file.SetFXML(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SetFXML(FXMLDocumentController fxml) {
        myFXML = fxml;
    }

    @FXML
    void createRes(ActionEvent event) throws IOException {

        String flightNumber = myFXML.provideFlight();
        String ersteName = firstName.getText();
        String letzeName = lastName.getText();
        String iD = idNumber.getText();

        //reservation(String name, String surname, String number, String choice) 
        reservation newReservation = new reservation(flightNumber, ersteName, letzeName, iD, seatSelection);
        allRes.add(newReservation);
        try {
            //Create file flight.txt and fills with input flights
            FileWriter reservations = new FileWriter("reservations.txt");
            BufferedWriter out = new BufferedWriter(reservations);

            for (int i = 0; i < allRes.size(); i++) {
                reservation current = allRes.get(i);
                out.write(current.getFlightNumber());
                out.write("          ");
                out.write(current.getFirst());
                out.write("          ");
                out.write(current.getLast());
                out.write("          ");
                out.write(current.getiD());
                out.write("          ");
                out.write(current.getSeat());
                out.write("          ");
                out.newLine();
            }
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        try {
            // Create file flight.txt and fills with input flights
            FileWriter passenger = new FileWriter(flightNumber + "passengers.txt", true);
            BufferedWriter jot = new BufferedWriter(passenger);
            //seat map
            
            jot.write(ersteName);
            jot.write("   ");
            jot.write(letzeName);
            jot.write("   ");
            jot.write(iD);
            jot.write("   ");
            jot.write(seatSelection);
            jot.newLine();
        
        //Close the output stream
        jot.close();

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }


    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    //supposed to make the seat the same as toggleButton text
    void setSeat(ToggleButton choice) {
        seatSelection = choice.getText();
    }
}
