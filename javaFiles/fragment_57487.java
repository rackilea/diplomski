package lj.HelloWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
 public class FXMLDocumentController {

@FXML private Label lblOutput;

@FXML protected void handleButtonAction(ActionEvent e){
lblOutput.setText("Hello World");
}
}