import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.SubScene;
import javafx.stage.Stage;

public final class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        SubScene scene = FXMLLoader.load(getClass().getResource(...));
        System.out.println(scene.getAntiAliasing());
        Platform.exit();
    }

}