package plot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {

    @FXML //  fx:id="openButton"
    private Button openButton; // Value injected by FXMLLoader

    @FXML
    public void open(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(openButton.getScene().getWindow());
        System.out.println(file);
    }

}