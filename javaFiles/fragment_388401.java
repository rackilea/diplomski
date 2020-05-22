import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class IndeterminateProgressBar extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();

        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);

        // If the progress bar is added to the root after the root is
        // added to the scene and the scene is added to the stage, it will
        // fail to be shown.
        ProgressBar progBar = new ProgressBar();
        progBar.setProgress(-1);
        root.getChildren().add(progBar);

        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}