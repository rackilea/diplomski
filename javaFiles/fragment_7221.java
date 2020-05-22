webview.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {

  @Override
  public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
    Platform.runLater(() -> {
      webview.getEngine().getLoadWorker().cancel();
    });
  }
});

webview.getEngine().locationProperty().addListener(new ChangeListener<String>() {

  @Override
  public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    getHostServices().showDocument(newValue);
  }
});