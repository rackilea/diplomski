TableView<Person> table = new TableView<>();
TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
nameColumn.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
    @Override
    public ObservableValue<String> call(CellDataFeatures<Person, String> cellData) {
        return new ReadOnlyStringWrapper(cellData.getValue().getName());
    }
});