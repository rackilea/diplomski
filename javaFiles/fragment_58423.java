engine = webView.getEngine();
link=new IndexLink(this);
engine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
    @Override
    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
        if (newValue == Worker.State.SUCCEEDED) {
            JSObject jsobj = (JSObject) engine.executeScript("window");
            jsobj.setMember("iLink", link);
            webView.setContextMenuEnabled(false);
        }
    }
});