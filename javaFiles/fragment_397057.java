import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CountingButton extends Application {


    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("Count");

        Timeline timeline = new Timeline();
        for (int count = 0; count <= 5 ; count++) {
            final String text = Integer.toString(count);
            KeyFrame frame = new KeyFrame(Duration.seconds(count), event -> 
                button.setText(text));
            timeline.getKeyFrames().add(frame);
        }

        button.setOnAction(e -> timeline.play());

        primaryStage.setScene(new Scene(new StackPane(button), 120, 75));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}