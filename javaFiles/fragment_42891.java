final WebView webView = new WebView();
final WebEngine webEngine = webView.getEngine();
webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
    if (newState == State.SUCCEEDED) {
        Document doc = webEngine.getDocument();
    }
});
webEngine.loadContent("<h1>hello</h1>");
//webEngine.load("http://google.ch"); // This works too