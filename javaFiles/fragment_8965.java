import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DroppedFileAsArgumentJavafxDemo extends Application {

    public static void main(String[] args) {
        // Launches javafx app using the arguments
        Application.launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        Label filename = new Label();

        // Receive arguments from launch(args)
        List<String> arguments = getParameters().getRaw();

        if (arguments.isEmpty()) {
            filename.setText("No file");
        } else {
            // sets text to first argument, the file name
            filename.setText(arguments.get(0));
        }

        // Display filename
        Scene s = new Scene(filename);
        window.setScene(s);
        window.show();
    }

}