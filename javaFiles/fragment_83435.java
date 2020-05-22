private class TextFieldListener implements ChangeListener<String> {
  private final TextField textField ;
  TextFieldListener(TextField textField) {
    this.textField = textField ;
  }
  @Override
  public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    // do validation on textField
  }
}