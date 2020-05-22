import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class Main extends Application {
    @Override

    public void start(Stage primaryStage) {
        WebView webview = new WebView();
        final WebEngine webengine = webview.getEngine();

        webengine.documentProperty().addListener((obs, oldDoc,  newDoc) -> {
            if (newDoc != null) {
                NodeList nodeList = newDoc.getElementsByTagName("img");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element img = (Element)nodeList.item(i);
                    String src = img.getAttribute("src");
                    System.out.println(src);
                }
            }
        });
        webengine.load("https://www.google.it/search?q=casa&biw=1440&bih=765&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiI0MvF0O3KAhUCGA8KHZixCzIQ_AUIBygC");
        primaryStage.setScene(new Scene(webview, 800, 800));
        primaryStage.show();
    }





    public static void main(String[] args) {
        launch(args);
    }
}