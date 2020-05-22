@FXML
private TableView<ObservableList> productsTable
@FXML
private TableColumn<ObservableList, String> column1
@FXML
private TableColumn<ObservableList, String> column2

...

    column1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
        @Override
        ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
            return new SimpleStringProperty(param.getValue().getAt(0).toString());
        }
    });
    column2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
        @Override
        ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
            return new SimpleStringProperty(param.getValue().getAt(1).toString());
        }
    });