import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SecondaryController implements Initializable{

    @FXML TextArea taSecondary;
    @FXML Button btnOk, btnCancel;

    Optional<String> returnValue;

    @Override
    public void initialize(URL url, ResourceBundle rb) {          
        btnOk.setOnAction((actionEvent) ->
        {
            returnValue = Optional.of(taSecondary.getText());
            ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();

        });   

        btnCancel.setOnAction((actionEvent) ->
        {
            returnValue = Optional.empty();
            ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
        });
    }

    public Optional<String> getNewItem()
    {
        return returnValue;
    }
}