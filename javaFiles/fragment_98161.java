import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FixedLineCountTextAreaTry extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Try to enter me more than 20 lines...");
        TextArea ta = new TextArea() {
            @Override
            public void replaceText(int start, int end, String text) {
                super.replaceText(start, end, text);
                while(getText().split("\n", -1).length > 20) {
                    int fle = getText().indexOf("\n");
                    super.replaceText(0, fle+1, "");
                }
                positionCaret(getText().length());
            }
        };

        StackPane root = new StackPane();
        root.getChildren().add(ta);
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
    }
}