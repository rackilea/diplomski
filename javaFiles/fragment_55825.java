import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisableFocusNavigation extends Application {

    private TextField createTextField() {
        TextField textField = new TextField();
        textField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.TAB) {
                System.out.println("Tab pressed");
                event.consume();
            }
        });
        return textField ;
    }

    @Override
    public void start(Stage primaryStage) {
        TextField tf1 = createTextField();
        TextField tf2 = createTextField();

        VBox root = new VBox(5, tf1, tf2);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}