import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Authenticate extends Application {

    static final String APP_ID = "...";
    static final String REDIRECT_URL = "https://login.live.com/oauth20_desktop.srf";
    static final String RESPONSE_TYPE = "token";
    static final String SCOPE = "wl.signin%20wl.offline_access";

    private Scene scene;

    @Override
    public void start(final Stage stage) throws Exception {
        final String url = "https://login.live.com/oauth20_authorize.srf?client_id="+APP_ID
                +"&scope="+SCOPE+"&response_type="+RESPONSE_TYPE+"&oauth_callback=oob&redirect_uri="+REDIRECT_URL;
        BorderPane borderPane = new BorderPane();

        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();

        webEngine.load(url);
        borderPane.setCenter(browser);

        webEngine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
            public void handle(WebEvent<String> event) {
                if (event.getSource() instanceof WebEngine) {
                    WebEngine we = (WebEngine) event.getSource();
                    String location = we.getLocation();
                    if (location.startsWith(REDIRECT_URL) && location.contains("access_token")) {
                        try {
                            URL url = new URL(location);
                            String[] params = url.getRef().split("&");
                            Map<String, String> map = new HashMap<String, String>();
                            for (String param : params) {
                                String name = param.split("=")[0];
                                String value = param.split("=")[1];
                                map.put(name, value);
                            }
                            System.out.println("The access token: "+map.get("access_token"));
                            stage.hide();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        // create scene
        stage.setTitle("Skydrive");
        scene = new Scene(borderPane, 750, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}