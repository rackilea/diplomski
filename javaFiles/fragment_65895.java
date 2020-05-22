package sample;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.io.IOException;

public class Main extends Application {

    // Primary Stage
    Stage window;
    // Two scenes
    Scene scene1, scene2;
    // The panes are associated with the respective .fxml files
    private Pane pane1;
    private Pane pane2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Set the window as primary stage
            window = primaryStage;

            // Load the fxml files and their controllers
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scene1.fxml"));
            pane1 = loader.load();
            Scene1Controller controller1 = loader.getController();

            loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scene2.fxml"));
            pane2 = loader.load();
            Scene2Controller controller2 = loader.getController();

            // The scenes are based on what has been loaded from the .fxml files
            Scene scene1 = new Scene(pane1);
            Scene scene2 = new Scene(pane2);

            // Pass reference the each scenes controller
            controller1.setScene2(scene2);
            controller1.setMain(this);
            controller2.setScene1(scene1);
            controller2.setMain(this);

            //Display scene 1 at first
            window.setScene(scene1);
            window.setTitle("Scene!");
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // used by the controllers to switch the scenes
    public void setScene(Scene scene){
        window.setScene(scene);
    }
}