package sample;

import javafx.scene.Scene;
import javafx.stage.Window;

public class Scene2Controller {

    private Scene scene1;
    private Main main;

    public void setMain(Main main){this.main = main;}
    public void setScene1(Scene scene1){this.scene1 = scene1;}
    // this method is called by clicking the button
    @FXML
    public void goBack(){main.setScene(scene1);}
}