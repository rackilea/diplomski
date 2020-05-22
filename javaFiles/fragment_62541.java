import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SizeTextAreaToString extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField enterField = new TextField();
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(1);

        enterField.setOnAction(e -> sizeTextAreaToText(textArea, enterField.getText()));

        VBox root = new VBox(5, enterField, textArea);
        VBox.setVgrow(textArea, Priority.NEVER);
        root.setPadding(new Insets(5));
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    private void sizeTextAreaToText(TextArea textArea, String text) {
        Text t = new Text(text);
        t.setFont(textArea.getFont());
        StackPane pane = new StackPane(t);
        pane.layout();
        double width = t.getLayoutBounds().getWidth();
        double padding = 20 ;
        textArea.setMaxWidth(width+padding);
        textArea.setText(text);
    }

    public static void main(String[] args) {
        launch(args);
    }
}