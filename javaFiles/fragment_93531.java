import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewWithLocalText extends Application {

    @Override
    public void start(Stage stage) throws MalformedURLException {
        String location =
                new File(
                        System.getProperty("user.dir") + File.separator + "test.txt"
                ).toURI().toURL().toExternalForm();

        System.out.println(location);

        WebView webView = new WebView();
        webView.getEngine().load(location);

        // use loadContent instead of load if you want a link to a file.
        // webView.getEngine().loadContent(
        //     "<a href=\"" + location + "\">Open File</a>"
        // );

        Scene scene = new Scene(webView);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}