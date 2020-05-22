@Override
protected void updateItem(Object value, boolean empty) {

    Object oldItem = getItem();
    if (oldItem != null) {
        myLabel.textProperty().unbind();
    }

    super.updateItem(value, empty);

    if (empty || value == null) {
        setGraphic(null);
    } else {
        setGraphic(myLabel);
        myLabel.textProperty().bind(value.myProperty());
    }
}