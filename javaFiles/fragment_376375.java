import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ProductionApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Test test = new Test("Hello World!");
        primaryStage.setScene(new Scene(test.getView(), 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}