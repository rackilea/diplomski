import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BiBindingExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Our StringProperty
        StringProperty stringProperty = new SimpleStringProperty();

        // Label to display our StringProperty
        Label label = new Label();
        label.textProperty().bind(stringProperty);

        // The ComboBox
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Zero", "One", "Two", "Three", "Four", "Five");

        // Bind the ComboBox value to that of the StringProperty, and vice versa
        comboBox.valueProperty().bindBidirectional(stringProperty);

        // A button to programmatically change the StringProperty
        Button button = new Button("Return to Zero");
        button.setOnAction(e -> stringProperty.set("Zero"));

        root.getChildren().addAll(comboBox, label, button);

        // Show the Stage
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}