@Override
public void start(Stage stage) throws Exception {

    WebView myWebView = new WebView();
    WebEngine engine = myWebView.getEngine();
    engine.load("https://twitter.com/");

    BorderPane root = new BorderPane();
    root.setCenter(myWebView);

    Scene scene = new Scene(root);
    stage.setScene(scene);

    stage.show();
}