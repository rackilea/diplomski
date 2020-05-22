@Override
protected void updateItem(String item, boolean empty) {
    super.updateItem(item, empty);

    if (item == null || empty) {
        setText(null);
        setStyle("");
    } else {

        // Check if file exists
        DataItem thisItem = getTableView().getItems().get(getIndex());
        File imageFile = new File("C:\\Users\\XXX\\Desktop\\"
                + thisItem.getCategory().getCategoryName() + "\\"
                + item);
        if (!imageFile.exists()) {
            setStyle("-fx-text-fill: red");
        } else {
            // modification here ----------------------------------------------
            setStyle("");
        }
        setText(item);
    }

}