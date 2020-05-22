import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.w3c.dom.Element;

public class WVTest extends Application {

    private WebView wv;

    @Override
    public void start(Stage primaryStage) {
        wv = new WebView();
        wv.getEngine().load(this.getClass().getResource("index.html").toExternalForm());
        // wv.getEngine().load("http://www.oracle.com/products/index.html");
        wv.getEngine().getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    @Override
                    public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
                        if (newState == State.SUCCEEDED) {
                            wv.requestFocus();
                            wv.getEngine().setUserStyleSheetLocation(getClass().getResource("style.css").toExternalForm());
                            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
                            Element maincontainer = (Element) wv.getEngine().executeScript("document.getElementById('pbody')");
                            System.out.println("maincontainer = " + maincontainer);
                            maincontainer.setAttribute("style", String.format("-webkit-transform: scale(%.5f)", (primaryScreenBounds.getHeight() / 768.0)));
                        }
                    }
                });

        VBox root = new VBox();
        root.getChildren().addAll(wv);

        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}