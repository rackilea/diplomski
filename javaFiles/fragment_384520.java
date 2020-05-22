@Override
protected void updateItem(Viewable item, boolean empty) {
    textProperty().unbind();
    styleProperty().unbind();
    if (empty || item == null) {
        setText(null);
        setStyle(null);
    } else {
        styleProperty().bind(item.styleProperty());
        textProperty().bind(item.titleProperty());
    }
    super.updateItem(item, empty);
}