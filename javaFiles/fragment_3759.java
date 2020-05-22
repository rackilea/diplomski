import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TextFieldFixedPrefix extends Application {

    private TextField createFixedPrefixTextField(String prefix) {
        TextField textField = new TextField(prefix);

        UnaryOperator<TextFormatter.Change> filter = c -> {
            if (c.getCaretPosition() < prefix.length() || c.getAnchor() < prefix.length()) {
                return null ;
            } else {
                return c ;
            }
        };

        textField.setTextFormatter(new TextFormatter<String>(filter));

        textField.positionCaret(prefix.length());

        return textField ;
    }

    @Override
    public void start(Stage primaryStage) {

        TextField textField = createFixedPrefixTextField("/home/currentUser $ ");
        StackPane root = new StackPane(textField);
        Scene scene = new Scene(root, 300,40);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}