arbCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> p) {
        return Bindings.selectString(
            new ReadOnlyObjectWrapper<Object>(
                p.getValue()
            ), 
            "arbeitgeber", "name"
        );
    }
});