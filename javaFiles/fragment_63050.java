import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AsyncExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        UI ui = new UI();
        DataProducer producer = new DataProducer(ui);
        producer.start();
        Scene scene = new Scene(ui.getView(), 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}