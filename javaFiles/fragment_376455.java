import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by John on 7/11/2014.
 */
public class Prog14_05 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create Pane
        CircularText phrase = new CircularText("TESTING MY CIRCULAR" +
                "TEXT OBJECT CLASS",
                500, 500);
        phrase.setFont("Courier New");
        phrase.setTextFill(Color.LIME);
        phrase.setTextSize(20);

        // Place clock and label in border pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(phrase.getTextSize()));
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: black");
        pane.getChildren().add(phrase);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_05");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}