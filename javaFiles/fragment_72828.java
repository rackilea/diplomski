import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordViewer extends Application {

    private static final int NUM_ITERATIONS = 200;
    private static final String bigWords =
            "Lorem";
    private static final String littleWords =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

    public void start(Stage stage) {
        Label smallLabel = new Label(
                IntStream.range(0, NUM_ITERATIONS)
                        .mapToObj(i -> littleWords)
                        .collect(Collectors.joining(" "))
        );
        smallLabel.setStyle(
                "-fx-font-size: 9px; " +
                "-fx-background-color: black; " +
                "-fx-text-fill: white"
        );
        smallLabel.setWrapText(true);
        smallLabel.setPrefWidth(1350);

        Label largeLabel = new Label(bigWords);
        largeLabel.setStyle(
                "-fx-font-size: 400px; " +
                "-fx-background-color: black; " +
                "-fx-text-fill: white"
        );

        largeLabel.prefWidthProperty().bind(smallLabel.widthProperty());
        largeLabel.prefHeightProperty().bind(smallLabel.heightProperty());
        largeLabel.setAlignment(Pos.CENTER);

        largeLabel.setBlendMode(BlendMode.MULTIPLY);

        StackPane layout = new StackPane(
                smallLabel,
                largeLabel
        );

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
}