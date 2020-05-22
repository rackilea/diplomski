import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class NewFXMain extends Application {

@Override
public void start(Stage primaryStage) {

    // get screensize of monitor
    Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

    // init buttons
    Button btn1 = new Button("switch to next scene >>");
    Button btn2 = new Button("<< switch to previous scene");

    // first rootNode
    StackPane root1 = new StackPane();
    root1.getChildren().add(btn1);
    Scene scene1 = new Scene(root1, screenSize.getWidth(), screenSize.getHeight());

    // second rootNode
    StackPane root2 = new StackPane();
    root2.getChildren().add(btn2);
    Scene scene2 = new Scene(root2, screenSize.getWidth(), screenSize.getHeight());

    // button actions
    btn1.setOnAction((ActionEvent event) -> {
        primaryStage.setScene(scene2);
    });
    btn2.setOnAction((ActionEvent event) -> {
        primaryStage.setScene(scene1);
    });

    primaryStage.setMaximized(true); // keep this since otherwise the titlebar is bit overlapped
    primaryStage.setScene(scene1);
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}