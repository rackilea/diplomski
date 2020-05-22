@Override
public void start(Stage stage) throws Exception {

    WebView myWebView = new WebView();
    WebEngine engine = myWebView.getEngine();
    engine.load("https://twitter.com/");

    VBox root = new VBox(); // or HBox 
    root.getChildren().add(myWebView);

    // HBox.setHgrow(myWebView, Priority.ALWAYS);
    VBox.setVgrow(myWebView, Priority.ALWAYS);

    Scene scene = new Scene(root);
    stage.setScene(scene);

    stage.show();
}