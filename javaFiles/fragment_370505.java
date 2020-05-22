import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressTaskExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple Interface
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        // The ProgressBar
        ProgressBar progressBar = new ProgressBar(0.0);

        // Button to start the task
        Button button = new Button("Run Task");
        button.setOnAction(event -> {

            System.out.println("Starting task ...");

            // Get the loading Task
            final Task<Void> task = Datasource.loadFromArxml();

            // Catch any exceptions
            task.setOnFailed(wse -> {
                System.out.println("Error");
                task.getException().printStackTrace();
            });

            // Print success when complete
            task.setOnSucceeded(wse -> {
                System.out.println("DONE!");
                progressBar.setStyle("-fx-accent: #19ee15");
            });

            // Bind our ProgressBar's properties
            progressBar.progressProperty().bind(task.progressProperty());

            // Run the task
            new Thread(task).start();

        });

        // Add our nodes to the scene
        root.getChildren().addAll(button, progressBar);

        // Show the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Sample");
        primaryStage.show();
    }
}