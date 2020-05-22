@Override
protected void updateItem(Object value, boolean empty) {
    super.updateItem(value, empty);

    myLabel.textProperty().unbind();

    if (empty || value == null) {
        setGraphic(null);
    } else {
        setGraphic(myLabel);
        myLabel.textProperty().bind(value.myProperty());
    }
}