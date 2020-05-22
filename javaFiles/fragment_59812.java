import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PrgorammaticallyPressButton extends Application {

    @Override
    public void start(Stage primaryStage) {
        IntegerProperty count = new SimpleIntegerProperty();
        Label label = new Label();
        label.textProperty().bind(count.asString("Count: %d"));

        Button button = new Button("Increment");
        button.setOnAction(e -> count.set(count.get()+1));



        VBox root = new VBox(5, label, button);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 150);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.UP) {
                button.arm();
                PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
                pause.setOnFinished(evt -> {
                    button.disarm();
                    button.fire();
                });
                pause.play();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}