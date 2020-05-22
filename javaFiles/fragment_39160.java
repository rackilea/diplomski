import javafx.application.Application;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CenterPromptText extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        textField.setPromptText("Enter something");

        PseudoClass empty = PseudoClass.getPseudoClass("empty");

        textField.pseudoClassStateChanged(empty, textField.getText().isEmpty());

        textField.textProperty().isEmpty().addListener((obs, wasEmpty, isNowEmpty) -> 
                textField.pseudoClassStateChanged(empty, isNowEmpty));

        VBox root = new VBox(5, textField, new Button("OK"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("center-prompt-text.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}