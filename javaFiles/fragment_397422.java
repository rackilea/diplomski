import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class AoEWebView extends Application {
    @Override public void start(final Stage stage) throws Exception {
        WebView webView = new WebView();
        webView.getEngine().load("http://ageofempiresgif.altervista.org/en/archive.php");

        stage.setScene(
                new Scene(
                        new Group(
                            webView
                        )
                )
        );
        stage.show();
    }

    public static void main(String[] args) { launch(AoEWebView.class); }
}