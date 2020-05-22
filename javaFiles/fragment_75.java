import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class TaskDemo extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        final Label label = new Label();

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                boolean fxApplicationThread = Platform.isFxApplicationThread();
                System.out.println("Is call on FXApplicationThread: " + fxApplicationThread);
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    updateMessage("Time elapsed: " + i);
                }
                return null;
            }

            @Override
            protected void succeeded() {
                boolean fxApplicationThread = Platform.isFxApplicationThread();
                System.out.println("Is call on FXApplicationThread: " + fxApplicationThread);
                super.succeeded();
                label.textProperty().unbind();
                label.setText("Task done");
            }
        };
        label.textProperty().bind(task.messageProperty());
        stage.setScene(new Scene(label, 300, 200));
        stage.show();
        new Thread(task).start();

    }
}