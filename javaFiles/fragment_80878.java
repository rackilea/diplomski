import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AutoCompleteTextAreaTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        Label currentWord = new Label();

        textArea.caretPositionProperty().addListener((obs, oldPosition, newPosition) -> {
            String text = textArea.getText().substring(0, newPosition.intValue());
            int index ;
            for (index = text.length() - 1; index >= 0 && ! Character.isWhitespace(text.charAt(index)); index--);
            String prefix = text.substring(index+1, text.length());
            currentWord.setText(prefix);
        });


        BorderPane root = new BorderPane(textArea, currentWord, null, null, null);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}