TextField textField = new TextField("123");
Button button = new Button("4");
button.setOnAction(click -> {
    String textFieldNewString = textField.getText() + button.getText();
    textField.setText(textFieldNewString);
}):