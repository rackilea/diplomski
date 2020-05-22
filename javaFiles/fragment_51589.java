import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Pane(), 300, 300);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            KeyCombination charCombo = new KeyCharacterCombination("+", KeyCombination.CONTROL_DOWN);
            KeyCombination codeCombo = new KeyCodeCombination(KeyCode.PLUS, KeyCombination.CONTROL_DOWN);

            @Override
            public void handle(KeyEvent event) {
                if (charCombo.match(event) || codeCombo.match(event)) {
                    System.out.println("Zoom in");
                }
            }
        });

        stage.setScene(scene);
        stage.show();
    }
}