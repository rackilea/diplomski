import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HistoryListComboBox extends Application {

    @Override
    public void start(Stage primaryStage) {
        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("One", "Two", "Three");
        combo.setEditable(true);
        combo.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (! combo.getItems().contains(newValue)) {
                List<String> newItems = new ArrayList<>();
                newItems.add(newValue);
                newItems.addAll(combo.getItems());
                combo.getItems().setAll(newItems);
            }
        });
        StackPane root = new StackPane(combo);
        primaryStage.setScene(new Scene(root, 350, 120));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}