import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class OneMinuteTimer extends Application {

    @Override
    public void start(Stage primaryStage) {
        ProgressBar progress = new ProgressBar();
        progress.setMinWidth(200);
        progress.setMaxWidth(Double.MAX_VALUE);
        IntegerProperty seconds = new SimpleIntegerProperty();
        progress.progressProperty().bind(seconds.divide(60.0));
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
            new KeyFrame(Duration.minutes(1), e-> {
                // do anything you need here on completion...
                System.out.println("Minute over");
            }, new KeyValue(seconds, 60))   
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        StackPane root = new StackPane(progress);
        root.setPadding(new Insets(20));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}