import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.*;
import javafx.stage.Stage;

public class LocationAfterLoadViewer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label location = new Label();

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load("http://www.fxexperience.com");

        engine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (Worker.State.SUCCEEDED.equals(newValue)) {
                location.setText(engine.getLocation());
            }
        });

        Scene scene = new Scene(new VBox(10, location, webView));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}