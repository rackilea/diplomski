package StackOverFlow;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class JavaFXTest extends Application {
private int counter = 0;
private Label label = new Label("Count: ");

public static void main (String [] args){
    Application.launch();
}

@Override
public void start(Stage primaryStage) throws Exception {
    Stage stage = new Stage();
    stage = primaryStage;

    Pane pane = new Pane();
    pane.setPrefSize(400,400);

    Button button = new Button("Smash it!");
    HBox root = new HBox(5, pane);

    button.setOnAction(e -> {
        label.setText("Count: "+Integer.toString(counter));
        counter();
    });
    root.getChildren().add(button);
    label.relocate(0, 0); // You can put this label, wherever you want!
    root.getChildren().add(label);

    Scene scene1 = new Scene(root,1000, 800, Color.AQUA);
    stage.setScene(scene1);
    stage.setTitle("ButtonSmash!");
    stage.show();


}


public void counter(){
    counter++;
    //System.out.println(counter);

}
}