@Override
public void start(Stage stage) throws Exception {
    stage.initStyle(StageStyle.TRANSPARENT);

    BorderPane container = new BorderPane();

    // WebView instantiated elsewhere ...
    container.setCenter(webView);

    scene = new Scene(container, 800, 600);
    scene.setFill(Color.TRANSPARENT);
    scene.getStylesheets().add(getClass().getResource("/root.css").toExternalForm());

    stage.setScene(scene);
    stage.show();

    webEngine.load(getClass().getResource("/index.html").toExternalForm());
    webEngine.setUserStyleSheetLocation(getClass().getResource("/reset.css").toString());

    // Mouse Events ...
}