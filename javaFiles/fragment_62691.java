import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BorderTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        // just create a control so the default stylesheet is loaded:
        new Label();

        Pane root = new Pane();
        root.getStyleClass().add("box");
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add("box-style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}