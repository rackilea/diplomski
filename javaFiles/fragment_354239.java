import java.util.Arrays;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ComboBoxWithLoadingMessage extends Application {

    @Override
    public void start(Stage primaryStage) {


        ComboBox<String> combo = new ComboBox<>();

        // mock loading task:
        Task<List<String>> loadingTask = new Task<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                // mimic long loading process:
                Thread.sleep(5000);
                return Arrays.asList("One", "Two", "Three", "Four", "Five");
            }
        };

        loadingTask.setOnSucceeded(e -> 
            combo.getItems().setAll(loadingTask.getValue()));


        ListCell<String> buttonCell = new ListCell<String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                State state = loadingTask.getState() ;
                if (state == State.SUCCEEDED ) {
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item);
                    }
                } 
            }
        };          

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> buttonCell.setText("Loading .")),
                new KeyFrame(Duration.millis(500), e -> buttonCell.setText("Loading . .")),
                new KeyFrame(Duration.millis(1000), e -> buttonCell.setText("Loading . . .")),
                new KeyFrame(Duration.millis(1500))
        );

        timeline.setCycleCount(Animation.INDEFINITE);

        loadingTask.stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == State.RUNNING) {
                timeline.play();
            } else {
                timeline.stop();
                if (buttonCell.isEmpty()) {
                    buttonCell.setText(null);
                } else {
                    buttonCell.setText(buttonCell.getItem());
                }
            }
        });

        combo.setButtonCell(buttonCell);

        new Thread(loadingTask).start();

        StackPane root = new StackPane(combo);
        Scene scene = new Scene(root, 350, 120);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}