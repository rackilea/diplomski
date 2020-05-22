import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextCSSTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);

        TextField textField = new TextField("Text Field");

        Label label = new Label("Label");

        Text text = new Text("Text");
        text.getStyleClass().add("my-text");

        root.getChildren().addAll(textField, label, text);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("text-css-test.css");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}