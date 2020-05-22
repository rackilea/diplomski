import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class QueuedTaskExample extends Application {

    private AtomicInteger taskCount = new AtomicInteger(0);

    private ExecutorService exec = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r);
        t.setDaemon(true); // allows app to exit if tasks are running
        return t ;
    });

    // Use the following if you want the tasks to run concurrently, instead of consecutively:

    // private ExecutorService exec = Executors.newCachedThreadPool(r -> {
    //     Thread t = new Thread(r);
    //     t.setDaemon(true);
    //     return t ;
    // });


    @Override
    public void start(Stage primaryStage) {

        // Just keep track of number of tasks pending/running for a status label:
        IntegerProperty pendingTasks = new SimpleIntegerProperty(0);

        Button startButton = new Button("Start");
        TextArea textArea = new TextArea();
        textArea.setEditable(true);
        startButton.setOnAction(event -> {
            Task<Void> task = createTask();
            // add text to text area if task's message changes:
            task.messageProperty().addListener((obs, oldMessage, newMessage) -> {
                textArea.appendText(newMessage);
                textArea.appendText("\n");
            });

            // for maintaining status label:
            pendingTasks.set(pendingTasks.get()+1);
            task.setOnSucceeded(taskEvent -> pendingTasks.set(pendingTasks.get()-1));

            // run task in single-thread executor (will queue if another task is running):
            exec.submit(task);
        });

        // layout etc
        HBox controls = new HBox(startButton);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(10));

        Label statusLabel = new Label();
        statusLabel.textProperty().bind(Bindings.format("Pending/running tasks: %s", pendingTasks));

        BorderPane root = new BorderPane(textArea, statusLabel, null, controls, null);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        exec.shutdownNow();
    }

    // Trivial task that counts slowly to 5, updating its message as it goes:
    private Task<Void> createTask() {
        final int taskNumber = taskCount.incrementAndGet();
        return new Task<Void>() {
            @Override 
            public Void call() throws Exception {
                for (int count=1; count<=5; count++) {
                    Thread.sleep(1000);
                    updateMessage("Task "+taskNumber+": Count "+count);
                }
                return null ;
            }
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}