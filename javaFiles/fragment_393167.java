import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TextFieldBug extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField tf = new TextField();
        tf.setTextFormatter(new TextFormatter<String>((Change c) -> {
            String text = c.getText();
            int oldAnchor = c.getAnchor();
            int oldCaretPos = c.getCaretPosition() ;
            int initialLength = text.length();
            text = text.replaceAll("\t", "    ");
            text = text.replaceAll("\n", "");
            c.setText(text);
            c.setAnchor(oldAnchor + text.length() - initialLength);
            c.setCaretPosition(oldCaretPos + text.length() - initialLength);
            return c ;
        }));
        primaryStage.setScene(new Scene(new StackPane(tf), 350, 120));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}