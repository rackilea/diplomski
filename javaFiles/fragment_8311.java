protected TableView<ObservableMap<String, CellDescriptor>> createTableView(TableFile tableFile)
{
    int columns = tableFile.getColumnCount();
    int rows = tableFile.getRowCount();

    ObservableList<ObservableMap<String, CellDescriptor>> data = FXCollections.observableArrayList();

    for (int i = 1; i < rows; i++)
    {
        ListOrderedMap<String, CellDescriptor> row = tableFile.getRow(i);
        ObservableMap<String, CellDescriptor> oRow = FXCollections.observableMap(row);
        data.add(oRow);
    }

    TableView<ObservableMap<String, CellDescriptor>> tableView = new TableView<>();
    tableView.setEditable(true);
    Callback<TableColumn<ObservableMap<String, CellDescriptor>, CellDescriptor>, TableCell<ObservableMap<String, CellDescriptor>, CellDescriptor>> cellFactory
        = (TableColumn<ObservableMap<String, CellDescriptor>, CellDescriptor> param) -> new ContextMenuCell();
    for (int i = 0; i < columns; i++)
    {
        String name = tableFile.getHeaderCell(i);
        String key = tableFile.getKey(i);
        TableColumn<ObservableMap<String, CellDescriptor>, CellDescriptor> tc = new TableColumn<>(name);
        tc.setCellValueFactory(new ObservableMapValueFactory<String, CellDescriptor>(key));
        tc.setCellFactory(cellFactory);
        tc.setOnEditCommit(
                (TableColumn.CellEditEvent<ObservableMap<String, CellDescriptor>, CellDescriptor> event) ->
                {
                    ObservableMap<String, CellDescriptor> map = event.getTableView().getItems().get(event.getTablePosition().getRow());
                    int ii = event.getOldValue().getI();
                    int jj = event.getOldValue().getJ();
                    String text = event.getNewValue().getText();
                    TableFile tf = event.getOldValue().getTf();
                    CellDescriptor newValue = new CellDescriptor(ii, jj, text, tf);
                    map.put(key, newValue);
                });
        ContextMenu columnContextMenue = createColumnContextMenu(i);
        tc.setContextMenu(columnContextMenue);
        tableView.getColumns().add(tc);
    }

    tableView.setItems(data);
    return tableView;
}