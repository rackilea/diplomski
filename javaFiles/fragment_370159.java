WebEngine engine = webview.getEngine();
engine.locationProperty().addListener((observable, oldValue, newValue) -> {
    if (newValue.contains("badsite")) { // replace with your URL checking logic
        Platform.runLater(() -> {
            // Load your block page url
            engine.load("http://example.com"));
        }
    }
});