package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Test2 extends Application{

public static void main(String[] args) {
    Test2.launch(args);     
}

@Override
public void start(Stage stage) throws Exception {
    DragDetectedHandler dragDetectedHandler = new 
       DragDetectedHandler("Test");
    Button button = new Button();
    button.setOnDragDetected(dragDetectedHandler);
    Scene scene = new Scene(button);
    stage.setScene(scene);
    stage.show();
}

}