import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // First, let's create a sample User, passing the username and email address to the constructor
        User user = new User("zephyr", "zephyr@home.com");

        primaryStage.setTitle("Data Object Sample");

        try {
            // Tell JavaFX where to find the FXML file and create a loader for it
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainLayout.fxml"));

            // Create a new MainController and pass our sample User to it
            MainController controller = new MainController(user);

            // Now that we've initialized our MainController with a User, let's set the controller for this FXML
            loader.setController(controller);

            // We may now load the FXML document and display the Scene
            primaryStage.setScene(new Scene(loader.load()));

            // Finally, show the Scene
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}