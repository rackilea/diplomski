import java.util.function.UnaryOperator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication362 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        ObservableList<String> options = FXCollections.observableArrayList(
                "A",
                "2",
                "3",
                "b"
        );

        TextField textField = new TextField();
        ComboBox<String> comboBox = new ComboBox<>(options);

        UnaryOperator<TextFormatter.Change> numbersOnly = (TextFormatter.Change change) -> {
            System.out.println(change);
            String text = change.getText();
            for (int i = 0; i < text.length(); i++) {
                if (!Character.isDigit(text.charAt(i))) {
                    return null;
                }
            }

            return change;
        };

        UnaryOperator<TextFormatter.Change> characterOnly = (TextFormatter.Change change) -> {
            System.out.println(change);
            String text = change.getText();
            for (int i = 0; i < text.length(); i++) {
                if (Character.isDigit(text.charAt(i))) {
                    return null;
                }
            }

            return change;
        };

        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (Character.isDigit(newValue.charAt(0))) {
                textField.clear();
                textField.setTextFormatter(new TextFormatter(numbersOnly));
            }
            else {
                textField.clear();
                textField.setTextFormatter(new TextFormatter(characterOnly));
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(comboBox, textField);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}