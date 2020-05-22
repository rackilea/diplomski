import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.*;
import javafx.stage.Stage;

public class LocationViewer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label location = new Label();

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load("http://www.fxexperience.com");

        location.textProperty().bind(engine.locationProperty());

        Scene scene = new Scene(new VBox(10, location, webView));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}