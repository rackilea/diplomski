TableColumn<Person, String> costAndModelCol = new TableColumn<Person, String>("Cost and Model of the product");
costAndModelCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> p) {
        return SimpleStringProperty(p.getValue().getCost().getValue() + " (model: "+ p.getValue().getModel().getYear() +")");
    }
});