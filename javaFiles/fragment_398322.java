import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {
    public static void main(final String[] args) {
        launch();
    }

    @Override
    public void init() {}

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Scene scene = new Scene(new ControllerA(primaryStage).getView());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}