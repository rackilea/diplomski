import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Button to show an alert
        Button btnShowAlert = new Button("Show Alert!");

        // Setup the button action
        btnShowAlert.setOnAction(event -> {

            // Create a simple Alert
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setHeaderText(null);
            alert.setTitle("Just a title");
            alert.setContentText("A fun message");
//            alert.initOwner(owner); // Remove for this sample

            ButtonType buttonPlayAgain = new ButtonType("Play again");
            alert.getButtonTypes().setAll(buttonPlayAgain);
//            alert.setOnHidden(evt -> Platform.exit()); // Don't need this

            // Listen for the Alert to close and get the result
            alert.setOnCloseRequest(e -> {
                // Get the result
                ButtonType result = alert.getResult();
                if (result != null && result == buttonPlayAgain) {
                    System.out.println("Play Again!");
                } else {
                    System.out.println("Quit!");
                }
            });

            alert.show();

        });

        root.getChildren().add(btnShowAlert);

        // Show the Stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}