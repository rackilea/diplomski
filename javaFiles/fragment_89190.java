TableView<Row> table = new TableView<>();

int numNodes = ... ;

TableColumn<Row, Number> stepCol = new TableColumn<>("Step");
stepCol.setCellValueFactory(cellData -> cellData.getValue().stepProperty());
table.getColumn().add(stepCol);

for (int n = 0 ; n < numNodes ; n++) {
    final int nodeIndex = n ;
    TableColumn<Row, String> reservedCol = new TableColumn<>("Reserved - "+nodeIndex);
    reservedCol.setCellValueFactory(cellData -> cellData.getValue().getNode(nodeIndex).reservedProperty());

    TableColumn<Row, String> reliabilityCol = new TableColumn<>("Reliability - "+nodeIndex);
    reliabilityCol.setCellValueFactory(cellData -> cellData.getValue().getNode(nodeIndex).reliabilityProperty());

    table.getColumns().add(reservedCol);
    table.getColumns().add(reliabilityCol);
}

TableColumn<Row, String> pCol = new TableColumn<>("P");
stepCol.setCellValueFactory(cellData -> cellData.getValue().pProperty());
table.getColumn().add(pCol);

TableColumn<Row, String> cCol = new TableColumn<>("C");
stepCol.setCellValueFactory(cellData -> cellData.getValue().cProperty());
table.getColumn().add(cCol);