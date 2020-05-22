import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LongInitApp extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        Task<Void> task = createLongStartTask();

        stage.setScene(new Scene(new Label("Application started"), 400, 400));

        LongAppInitPreloader preloader = new LongAppInitPreloader();
        preloader.progressProperty().bind(task.progressProperty());

        task.setOnSucceeded(e -> {
            stage.show();
            preloader.hide();
        });
        preloader.show();

        new Thread(task).start();
    }

    private Task<Void> createLongStartTask() {
        // simulate long init in background
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int max = 10;
                for (int i = 1; i <= max; i++) {
                    Thread.sleep(200);
                    updateProgress(i, max);
                }

                return null;
            }
        };
        return task ;
    }

    // just here so I can run directly from Eclipse:
    public static void main(String args[]) {
        launch(args);
    }
}