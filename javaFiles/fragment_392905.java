import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller{

    @FXML
    public Label label;

    public void setText(String text) {
        label.setText(text);
    }
}