package pkgfinal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TableView<flight> flightLog;

    private ArrayList<flight> flightrecords;
    private ArrayList<String> flightNumbers;
    public String selectedFlight;

    private ObservableList<flight> logs;

    @FXML
    private TableColumn<flight, String> flightColumn;

    @FXML
    private TableColumn<flight, String> dateColumn;

    @FXML
    private TableColumn<flight, String> dTime;

    @FXML
    private TableColumn<flight, String> aTime;

    @FXML
    private TableColumn<flight, String> departing;

    @FXML
    private TableColumn<flight, String> arriving;

    @FXML
    private TableColumn<flight, Integer> seatsleft;

    @FXML
    private Button newFlight;

    @FXML
    private Button reserveFlight;

    @FXML
    private Button seating;

    @FXML
    private Button flightPassengers;

    @FXML
    private Button allReserves;

    @FXML
    private ChoiceBox<String> dropDown;

    public ArrayList<String> allesFluegen;

    // opens window to create new flight
    @FXML
    private void addNew(ActionEvent event) {
        try {
            FXMLLoader newflight = new FXMLLoader(getClass().getResource("newflight.fxml"));
            Parent root = newflight.load();
            NewflightController file = newflight.getController();
            file.setflights(flightrecords);
            file.setflightNumbers(flightNumbers);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        populate();
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        flightrecords = new ArrayList<>();
        flightNumbers = new ArrayList<>();

        flightColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dTime.setCellValueFactory(new PropertyValueFactory<>("deptTime"));
        aTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
        departing.setCellValueFactory(new PropertyValueFactory<>("departing"));
        arriving.setCellValueFactory(new PropertyValueFactory<>("arriving"));
        seatsleft.setCellValueFactory(new PropertyValueFactory<>("seats"));

        ChangeListener<String> changeListener = new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, //
                    String oldValue, String newValue) {
                selectedFlight = newValue;
            }
        };

        dropDown.getSelectionModel().selectedItemProperty().addListener(changeListener);

    }

    private void populate() {
        // populates table with flight information

        logs = FXCollections.observableArrayList(flightrecords);
        flightLog.setItems(logs);
        flightLog.refresh();
        ObservableList<String> allFlights = FXCollections.observableArrayList(flightNumbers);
        dropDown.setItems(allFlights);

    }

    // opens window to check/choose seating
    @FXML
    private void checkSeating(ActionEvent event) throws IOException {

        try {
            FXMLLoader seating = new FXMLLoader(getClass().getResource("seatMap.fxml"));
            Parent root = (Parent) seating.load();
            SeatMapController seatMap = seating.getController();
            seatMap.setChart(selectedFlight);
            seatMap.initialize();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // opens window to create reservation
    @FXML
    private void createReservation(ActionEvent event) {
        try {
            FXMLLoader newRes = new FXMLLoader(getClass().getResource("newRes.fxml"));
            Parent root = (Parent) newRes.load();
            NewResController file = newRes.getController();
            file.SetFXML(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String provideFlight() {
        return selectedFlight;
    }

    // opens window to view passenger list
    @FXML
    private void listPassengers(ActionEvent event) throws IOException {

        try {
            FXMLLoader passengerList = new FXMLLoader(getClass().getResource("flightpassengers.fxml"));
            Parent root = (Parent) passengerList.load();
            FlightpassengersController content = passengerList.getController();
            content.setFlight(selectedFlight);
            content.initialize();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // opens window view reservations
    @FXML
    private void showReserves(ActionEvent event) {
        try {
            FXMLLoader allReservations = new FXMLLoader(getClass().getResource("reservationspage.fxml"));
            Parent root = (Parent) allReservations.load();
            ReservationspageController file = allReservations.getController();
            file.initialize();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
