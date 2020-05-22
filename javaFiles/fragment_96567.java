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

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Layout.fxml"));
            loader.setController(new Controller());

            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.setTitle("Dynamic TextFields Example");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}