package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SampleApp extends Application {
    public static void main(String[] args) {
        launch(SampleApp.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/sample/Sample.fxml")));
        primaryStage.setScene(scene );
        primaryStage.show();
        scene.getRoot().requestFocus();
    }
}