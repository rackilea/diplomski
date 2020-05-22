@Override
protected void updateItem(Entry entry, boolean empty) {
    super.updateItem(entry, empty);

    textProperty().unbind();

    if (empty || entry == null) {
        setText(null);
        setGraphic(null);
    } else {
        if (entry.getImage() != null) {
            Image image = FXUtils.toFXImage(entry.getImage());
            setGraphic(new ImageView(image));
        } else {
            setGraphic(null);
        }

        textProperty().bind(entry.nameProperty());
    }

}