import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField textField ;

    @FXML
    private void printMessage() {
        System.out.println(textField.getText());
    }
}