package sample;

import javafx.scene.Scene;
import javafx.stage.Window;

public class Scene1Controller {

    private Scene scene2;
    private Main main;

    public void setMain(Main main){
        this.main = main;
    }
    public void setScene2(Scene scene2){
        this.scene2 = scene2;
    }
    // this method is called by clicking the button
    @FXML
    public void switchScene(){main.setScene(scene2);}
}