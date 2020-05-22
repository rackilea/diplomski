WebEngine engine = webView.getEngine();
    engine.getLoadWorker().stateProperty().addListener(
        (o, old, state) -> updateFrameList(state));
    engine.load(url);

// ...

private void updateFrameList(Worker.State loadState) {
    if (loadState == Worker.State.SUCCEEDED) {
        Document doc = webView.getEngine().getDocument();