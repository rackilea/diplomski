import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class SampleController {

    private int count = 0 ;

    @FXML
    private Label countLabel ;

    @FXML
    private void increment() {
        count++;
        countLabel.setText("Count: "+count);
    }
}