import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Worker;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.transform.Scale;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.net.URL;
import java.util.Set;

public class Main extends Application {

  private Scene scene;
  MyBrowser myBrowser;

  @Override
  public void start(Stage primaryStage) throws Exception{
    primaryStage.setTitle("Test web");

    myBrowser = new MyBrowser();
    scene = new Scene(myBrowser, 1080, 1920);

    primaryStage.setScene(scene);
    primaryStage.setFullScreen(true);
    primaryStage.show();

  }
  public static void main(String[] args) {
    launch(args);
  }
}


class MyBrowser extends Region {

  final String hellohtml = "index.html";

  WebView webView = new WebView();
  WebEngine webEngine = webView.getEngine();


  public MyBrowser(){

    URL urlHello = getClass().getResource(hellohtml);
    webEngine.load(urlHello.toExternalForm());
    webView.setPrefSize(1080, 1920);
    webView.getChildrenUnmodifiable().addListener(new ListChangeListener<Node>() {
      @Override public void onChanged(Change<? extends Node>
                                          change) {
        Set<Node> deadSeaScrolls = webView.lookupAll(".scroll-bar");
        for (Node scroll : deadSeaScrolls) {
          scroll.setVisible(true);
        }
      }
    });

  webEngine. getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
    if (newValue == Worker.State.SUCCEEDED) {
      JSObject window = (JSObject) webEngine.executeScript("window");
      window.setMember("app", this);
    }   });

    getChildren().add(webView);
  }

  /**
   * Callback function from the JavaScript code.
   */
  public void print() {
    print(webView);
  }

  /** Scales the node based on the standard letter, portrait paper to be printed.
   * @param node The scene node to be printed.
   */
  public void print(final Node node) {
    Printer printer = Printer.getDefaultPrinter();
    PageLayout pageLayout = printer.createPageLayout(Paper.NA_LETTER, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
    double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
    double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
    node.getTransforms().add(new Scale(scaleX, scaleY));

    PrinterJob job = PrinterJob.createPrinterJob();
    if (job != null) {
      boolean success = job.printPage(node);
      if (success) {
        job.endJob();
      }
    }
  }
}