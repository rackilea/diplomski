import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LookedUpSizeTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Test");
        StackPane stack = new StackPane(button);
        BorderPane root = new BorderPane(stack);

        Slider sizeSlider = new Slider(30, 350, 40);

        stack.styleProperty().bind(sizeSlider.valueProperty().asString("button-size: %f ;"));

        root.setBottom(sizeSlider);

        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add("style.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}