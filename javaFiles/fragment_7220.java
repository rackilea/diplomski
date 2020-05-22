import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HTMLEditorSample extends Application {

  @Override
  public void start(Stage stage) {

    stage.setTitle("HTMLEditor Sample");
    stage.setWidth(400);
    stage.setHeight(300);
    final HTMLEditor htmlEditor = new HTMLEditor();

    htmlEditor.setPrefHeight(245);
    Scene scene = new Scene(htmlEditor);
    stage.setScene(scene);
    stage.show();

    URL.setURLStreamHandlerFactory(protocol -> {

      if (protocol.startsWith("http")) {
        return new CustomUrlHandler();
      }

      return null;
    });

    WebView webview = (WebView) htmlEditor.lookup(".web-view");
    webview.getEngine().load("http://google.com");

  }

  public static void main(String[] args) {
    launch(args);
  }

  public class CustomUrlHandler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
      return new HostServicesUrlConnection(u, getHostServices());
    }
  }

  public class HostServicesUrlConnection extends HttpURLConnection {

    private URL urlToOpen;
    private HostServices hostServices;

    protected HostServicesUrlConnection(URL u, HostServices hostServices) {
      super(u);
      this.urlToOpen= u;
      this.hostServices = hostServices;
    }

    @Override
    public void disconnect() {
      // do nothing
    }

    @Override
    public boolean usingProxy() {
      return false;
    }

    @Override
    public void connect() throws IOException {
      hostServices.showDocument(urlToOpen.toExternalForm());
    }

    @Override
    public InputStream getInputStream() throws IOException {
      return new InputStream() {

        @Override
        public int read() throws IOException {
          return 0;
        }
      };
    }

  }
}