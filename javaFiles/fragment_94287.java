column.setCellFactory(param -> new TableCell<TableValues, String>() {
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setText(null);
            setCursor(Cursor.DEFAULT);
            setOnMouseClicked(null);
        } else {
            setText(item);
            setCursor(Cursor.CLOSED_HAND);
            setOnMouseClicked(event -> {
                System.out.println("Clicked on " + item);
                // do what you want to do on click
            });
        }
    }
});