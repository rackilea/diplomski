stage.focusedProperty().addListener(new ChangeListener<Boolean>() {
  @Override
  public void changed(ObservableValue<? extends Boolean> observableValue, Boolean wasFocused, Boolean focused) {
    stage.toBack();
  }
});

stage.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
  @Override
  public void handle(MouseEvent mouseEvent) {
    stage.toBack();
  }
});