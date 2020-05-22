import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) {
    Text text = new Text();
    primaryStage.addEventHandler(KeyEvent.KEY_TYPED, event -> {
      event.consume();
      text.setText(text.getText() + event.getCharacter());
    });
    primaryStage.setScene(new Scene(new StackPane(text), 500, 300));
    primaryStage.show();
  }
}