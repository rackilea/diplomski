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
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainLayout.fxml"));

            primaryStage.setTitle("TableView Sample");
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}