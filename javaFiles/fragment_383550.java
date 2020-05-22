import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TextFillTransition extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Transitioning the fill of a label");
        label.setStyle("-fx-font-size: 24pt ;");

        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(0), new KeyValue(label.textFillProperty(), Color.RED)),
            new KeyFrame(Duration.seconds(2), new KeyValue(label.textFillProperty(), Color.GREEN))
        );
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        StackPane root = new StackPane(label);
        root.setPadding(new Insets(12));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}