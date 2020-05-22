static TableView<String[]> createTable(String... columnNames) {
    TableView<String[]> table = new TableView<>();

    for (int i = 0; i < columnNames.length; i++) {
        final int index = i;
        TableColumn<String[], String> column = new TableColumn<>(columnNames[i]);
        column.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue()[index]));
        table.getColumns().add(column);
    }

    return table;
}