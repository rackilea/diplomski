for (String group : groups) {
    TableColumn<AttributeRow, Boolean> groupColumn = new TableColumn<>(group);
    groupColumn.setCellFactory(CheckBoxTableCell.forTableColumn(groupColumn));
    groupColumn.setCellValueFactory(cellData -> cellData.getValue().activeProperty(group));
    attributeTable.getColumns().add(groupColumn);
}