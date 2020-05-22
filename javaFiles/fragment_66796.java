TableColumn<Member, Boolean> colected_column = ...;

colected_column.setCellValueFactory((TableColumn.CellDataFeatures<Member, Boolean> param) -> {
    Member mRow = param.getValue(); // type objects contained within the TableView
    return nRow.collectedProperty();
});
colected_column.setCellFactory(CheckBoxTableCell.forTableColumn(colected_column));