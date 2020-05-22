package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

  public void start(Stage stage) {
    Parent root = null;

    try {
      root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    Scene scene = new Scene(root, 300, 275);
    stage.setTitle("FXML Welcome");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}