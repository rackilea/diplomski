import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SliderTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Slider slider = new Slider();
        slider.valueProperty().addListener((obs, oldValue, newValue) -> {
            double percentage = 100.0 * (newValue.doubleValue() - slider.getMin()) / (slider.getMax() - slider.getMin());
            slider.setStyle("-track-color: linear-gradient(to right, #90C7E0 " + percentage+"%, white "+percentage+("%);"));
        });
        StackPane root = new StackPane(slider);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}