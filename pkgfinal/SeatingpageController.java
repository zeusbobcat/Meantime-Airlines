package pkgfinal;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SeatingpageController {

    @FXML
    private HBox seatingChart;

    @FXML
    private VBox aSeats;

    @FXML
    private VBox bSeats;

    @FXML
    private VBox cSeats;

    @FXML
    private VBox dSeats;

    @FXML
    private VBox eSeats;

    @FXML
    private VBox fSeats;

    @FXML
    private VBox gSeats;

    @FXML
    private NewResController res;

    ArrayList<ToggleButton> seats = new ArrayList<ToggleButton>();

    @FXML
    private ToggleGroup justOne;
    
    ToggleButton selection = new ToggleButton();

    //@Override
    public void initialize(URL location, ResourceBundle resources) {

        //puts all toggleButtons in each VBox (within the Hbox) in justOne
        //sets seat equal to selected toggleButton
        for (Node child : seatingChart.getChildren()) {
            VBox each = (VBox) child;
            for (Node button : each.getChildren()) {
                ToggleButton seat = (ToggleButton) button;
                seat.setToggleGroup(justOne);
                seat.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                            System.out.print(oldValue);
                            System.out.print(newValue);
                        if(newValue){
                            selection = seat;
                        }
                    }
                });
                seats.add(seat);
            }
        }
        //seats.forEach(selection.onMouseClickedProperty(res.setSeat(seat)));
    }

    
    public void SetFXML(NewResController fxml) {
        res = fxml;
    }

}
