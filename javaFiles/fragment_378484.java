@Override
void updateItem(final String item, final boolean empty) {
    super.updateItem(item, empty);

    // if null, display nothing
    if (empty || item == null) {
        setText(null);
        setGraphic(null);
        return;
    }

    setText(null);

    Label textLabel = new Label(item + " ");

    final HBox hbox = new HBox();
    hbox.setSpacing(5);

    Label iconLabel = new Label();
    iconLabel.setGraphic(new ImageView(new Image("huisteken.jpg")));

    hbox.getChildren().addAll(iconLabel, textLabel);
    setGraphic(hbox);
}