import javafx.application.Application;
import javafx.beans.value.*;
import javafx.scene.Scene;
import javafx.scene.web.*;
import javafx.stage.Stage;
import org.w3c.dom.Document;

public class WebViewHeight extends Application {
  @Override public void start(Stage primaryStage) {
    final WebView webView = new WebView();
    final WebEngine engine = webView.getEngine();
    engine.load("http://docs.oracle.com/javafx/2/get_started/animation.htm");
    engine.documentProperty().addListener(new ChangeListener<Document>() {
      @Override public void changed(ObservableValue<? extends Document> prop, Document oldDoc, Document newDoc) {
        String heightText = webView.getEngine().executeScript(
          "window.getComputedStyle(document.body, null).getPropertyValue('height')"
        ).toString();
        double height = Double.valueOf(heightText.replace("px", ""));    

        System.out.println(height);
      }
    });
    primaryStage.setScene(new Scene(webView));
    primaryStage.show();
  }

  public static void main(String[] args) { launch(args); }
}