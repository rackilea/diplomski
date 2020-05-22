package test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChildController implements Initializable {
    @FXML
    AnchorPane ap;
    @FXML
    private Button btnone;
    @FXML
    private Button btntwo;
    @FXML
    private Button btnthree;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void one(ActionEvent event) {
        handleEvent(1);
    }

    @FXML
    private void two(ActionEvent event) {
        handleEvent(2);
    }

    @FXML
    private void three(ActionEvent event) {
        handleEvent(3);
    }

    private void handleEvent(int chosenNumber) {
        Stage stage = (Stage) ap.getScene().getWindow();
        Stage owner = (Stage) stage.getOwner();
        Scene scene = owner.getScene();
        Parent root = scene.getRoot();
        TextField txtFld = (TextField) root.lookup("#txtFld");
        txtFld.setText(String.valueOf(chosenNumber));
        stage.close();
    }
}