WebEngine webEngine = webView.getEngine();
    webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
        @Override
        public void changed(ObservableValue<? extends State> ov, State t, State t1) {
            if (t1 == Worker.State.SUCCEEDED) {
                JSObject window = (JSObject) webEngine.executeScript("window");
                window.setMember("app", this);
            }
        }
    });