import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) {
    ScrollPane root = new ScrollPane(new ImageView(/* your image */));
    root.setHbarPolicy(ScrollBarPolicy.NEVER);
    root.setVbarPolicy(ScrollBarPolicy.NEVER);
    root.setPannable(true);
    primaryStage.setScene(new Scene(root, 1000, 650));
    primaryStage.show();
  }
}