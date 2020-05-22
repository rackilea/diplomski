import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller{

    @FXML
    private Button buttonA, buttonB;

    public void buttonAClicked(){
        System.out.println("Button A clicked");
    }

    public void buttonBClicked(){
        System.out.println("Button B clicked");
    }
}