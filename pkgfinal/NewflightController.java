package pkgfinal;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import pkgfinal.flight;

/**
 * creates and populates flights.txt
 */
public class NewflightController implements Initializable {

    @FXML
    private TextField flightnumber;

    @FXML
    private TextField flightDate;

    @FXML
    private TextField timeOut;

    @FXML
    private TextField timeIN;

    @FXML
    private TextField cityLeft;

    @FXML
    private TextField cityLand;

    @FXML
    private Button createFlight;

    private ArrayList<flight> flightrecords;
    private ArrayList<String> flightNumbers;

    @FXML
    void addFlight(ActionEvent event) throws IOException {

        String flight = flightnumber.getText();
        String date = flightDate.getText();
        String dTime = timeOut.getText();
        String aTime = timeIN.getText();
        String departing = cityLeft.getText();
        String arriving = cityLand.getText();
        int seatsavailable = 56;

        flight newFlight = new flight(flight, date, dTime, aTime, departing, arriving, seatsavailable);

        flightrecords.add(newFlight);
        flightNumbers.add(newFlight.getNumber());
        
        try {
            // Create file flight.txt if not created and fills with input flights. Appends to file if created
            FileWriter allflights = new FileWriter("flights.txt", true);
            BufferedWriter out = new BufferedWriter(allflights);

            for (int i = 0; i < flightrecords.size(); i++) {
                flight current = flightrecords.get(i);
                out.write(current.getNumber());
                out.write("          ");
                out.write(current.getDate());
                out.write("          ");
                out.write(current.getDeptTime());
                out.write("          ");
                out.write(current.getArrivalTime());
                out.write("          ");
                out.write(current.getDeparting());
                out.write("          ");
                out.write(current.getArriving());
                out.write("          ");
                out.write(String.valueOf(seatsavailable));
                out.newLine();
            }
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        String seatMap[] = {"A", "B", "C", "D", "E", "F", "G"};
        //creates file for flight
        try {
            // Create file flight.txt and fills with input flights
            FileWriter flightFile = new FileWriter(flight + ".txt");
            BufferedWriter jot = new BufferedWriter(flightFile);
            //seat map
            int length = seatMap.length + 1;
            for (int c = 0; c < length; c++) {
                
                for(int r = 0; r < seatMap.length; r++){
                    jot.write(String.valueOf(c + 1));
                    jot.write("");
                    String test = (seatMap[r]);
                    jot.write(test);
                    jot.write("   ");                    
                }
                jot.newLine();
            }
            //Close the output stream
            jot.close();

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    //compiles list of flights [object]
    //for use in FXMLDocumentController
    public void setflights(ArrayList<flight> flights) {
        flightrecords = flights;
    }
    //compiles list of flight numbes
    //for use in FXMLDocumentController
    public void setflightNumbers(ArrayList<String> codes) {
        flightNumbers = codes;
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }
}
