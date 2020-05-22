public void initialize(URL url, ResourceBundle rb) {
    //...
    labels.forEach(this::addMouseClickedEventHandler);
}

private void addMouseClickedEventHandler(Label label) {
    label.setOnMouseClicked(event -> {
        label.setText("new text");
        event.consume();
    });
}