inputACol.setCellFactory(param -> new EditingCell() {
    @Override
    public void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) {
            ItemsTableLine data = (ItemsTableLine) getTableView().getItems().get(getIndex());
            disableProperty().bind(Bindings.createBooleanBinding(() ->
                    !data.typeProperty().get().equals("A"), data.typeProperty()));
        } else {
            disableProperty().unbind();
        }
    }
});
inputBCol.setCellFactory(param -> new EditingCell() {
    @Override
    public void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) {
            ItemsTableLine data = (ItemsTableLine) getTableView().getItems().get(getIndex());
            disableProperty().bind(Bindings.createBooleanBinding(() ->
                    !data.typeProperty().get().equals("B"), data.typeProperty()));
        } else {
            disableProperty().unbind();
        }
    }
});