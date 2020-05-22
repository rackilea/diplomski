import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication149 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        TextField textField = new TextField();
        textField.setTextFormatter(new TextFormatter<>(c
                -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }

            if (c.getControlNewText().matches("[A-z]") || c.getControlNewText().matches("[A-z]\\d+") || c.getControlNewText().matches("[A-z]\\d+[A-z]")) {
                return c;
            }
            else {
                return null;
            }

        }));



        StackPane root = new StackPane(textField);
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