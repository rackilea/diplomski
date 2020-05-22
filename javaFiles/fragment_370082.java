import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SecondViewController implements Initializable {

    @FXML private Label secondInfoLbl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        secondInfoLbl.setText("Hello from the second view");
    }
}