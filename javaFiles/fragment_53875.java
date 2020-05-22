@Override
protected void updateItem(Hyperlink item, boolean empty) {
    super.updateItem(item, empty);
    if (!empty){
        item.setOnAction(e -> {
            TeDhenatBlerjes(Integer.parseInt(getTableView().getColumns().get(0).getCellData(getTableRow().getIndex())+""), item.getText());
        });
    }

    // set graphic every time i.e. set it to null for empty cells
    setGraphic(item);
}