import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class DatePickerCommit extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple Interface
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        DatePicker datePicker = new DatePicker();

        // Add listener on DatePicker
        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Option#1
               datePicker.getEditor().setText(datePicker.getConverter().toString(newValue));
               showAlert(newValue);

               // Option#2
               //Platform.runLater(()->showAlert(newValue));
            }
        });

        root.getChildren().add(datePicker);

        // Show the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Sample");
        primaryStage.show();
    }

    private void showAlert(LocalDate value){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("You selected " + value);
        alert.show();
        alert.setY(alert.getY()+100);
    }
}