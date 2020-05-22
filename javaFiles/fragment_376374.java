import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // launch app:

        Test test = new Test("Testing");
        primaryStage.setScene(new Scene(test.getView(), 300, 250));
        primaryStage.show();

        // update text in 5 seconds:

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException exc) {
                throw new Error("Unexpected interruption", exc);
            }
            Platform.runLater(() -> test.setText("Hello World!"));
        });
        thread.setDaemon(true);
        thread.start();

    }    
}