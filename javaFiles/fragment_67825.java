myList.setCellFactory(list -> new ListCell<String>() {

    {
        setWrapText(true);
        prefWidthProperty().bind(list.widthProperty().subtract(12));
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null || item == null) {
            setText(null);
        } else {
            setText(item.toUpperCase());
        }
    }
});