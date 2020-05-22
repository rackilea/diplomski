webComponent.getEngine().load(getClass().getResource("googlemap.html").toString());

webComponent.getEngine().stateProperty().addListener(new ChangeListener<Worker.State>() {
    @Override
    public void changed(ObservableValue<? extends Worker.State> ov, Worker.State t, Worker.State t1) {
        if (t1 == Worker.State.SUCCEEDED) {
            // this will be run as soon as WebView is initialized.
            webComponent.getEngine().executeScript("document.goToLocation(\"" + urlField.getText() + "\")");               
        }
    }
});