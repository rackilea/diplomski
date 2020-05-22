import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ToggleButtonDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        ToggleButton apples = new ToggleButton("Apples");
        ToggleButton oranges = new ToggleButton("Oranges");
        ToggleButton pears = new ToggleButton("Pears");

        ToggleGroup fruitToggleGroup = new ToggleGroup();
        fruitToggleGroup.getToggles().addAll(apples, oranges, pears);

        fruitToggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> 
                System.out.println("Selected toggle changed from "+oldToggle+" to "+newToggle));

        HBox root = new HBox(5, apples, oranges, pears);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 350, 75);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}