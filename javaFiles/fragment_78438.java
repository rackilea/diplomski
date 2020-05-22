import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Display extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(loader.load(), 800, 400));
    primaryStage.show();

    Controller controller = loader.getController();

    Thread machineryThread = new Thread(() -> {
        // some processes launching after the GUI, including updating the label
        // which you can now easily do with
        Platform.runLater(() -> controller.setLabel("Some new text"));
    });
    machineryThread.start();
  }


}