import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

        button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Rectangle rect1 = new Rectangle(60, 20);
        rect1.setFill(Color.TRANSPARENT);
        Rectangle rect2 = new Rectangle(60, 20);
        rect2.setFill(Color.TRANSPARENT);

        HBox box = new HBox(10, rect1, button1, button2, rect2);
        box.setAlignment(Pos.CENTER);
        HBox.setHgrow(button1, Priority.ALWAYS);
        HBox.setHgrow(button2, Priority.ALWAYS);

        BorderPane root = new BorderPane();
        root.setBottom(box);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Main Stage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}