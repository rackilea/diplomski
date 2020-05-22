customTypeCol1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MessageType3, Boolean>, ObservableValue<Boolean>>() {
    @Override
    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<MessageType3, Boolean> p) {
        return new SimpleBooleanProperty(p.getValue().getOne());
    }
});