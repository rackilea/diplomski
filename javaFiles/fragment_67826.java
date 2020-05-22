myList.setCellFactory(list -> new ListCell<String>() {

    private Text text = new Text();

    {
        prefWidthProperty().bind(widthProperty().subtract(12));
        text.wrappingWidthProperty().bind(widthProperty());
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null || item == null) {
            setGraphic(null);
        } else {
            text.setText(item.toUpperCase());
            setGraphic(text);
        }
    }
});