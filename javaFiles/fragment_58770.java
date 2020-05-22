package soundboardEoZ;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {
    int index = 2;

    @FXML
    GridPane button_grid;

    public void test(){
        System.out.println("Testing");
    }

    public void addButton(){
        Button sound_button = new Button("Button_" + index);
        button_grid.add(sound_button, index,2);
        index++;
    }

}