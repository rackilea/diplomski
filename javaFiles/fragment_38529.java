customTypeCol1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MessageType3, Boolean>, ObservableValue<Boolean>>() {
    @Override
    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<MessageType3, Boolean> p) {
        if (p.getValue() instanceof MessageType3) {
            return new SimpleBooleanProperty(p.getValue().getOne());
        } else {
            return null;
        }
    }
});