import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AsyncExample extends Application {

    private final int MAX_QUEUE_SIZE = 10 ;

    @Override
    public void start(Stage primaryStage) {

        BlockingQueue<MyDataClass> queue = new ArrayBlockingQueue<>(MAX_QUEUE_SIZE);
        UI ui = new UI(queue);
        DataProducer producer = new DataProducer(queue);
        producer.start();
        Scene scene = new Scene(ui.getView(), 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}