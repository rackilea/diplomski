TreeTableView<Object> treeTable = new TreeTableView<>();
treeTable.setShowRoot(false);

TreeTableColumn<Object, String> nameColumn = new TreeTableColumn<>("Name");
nameColumn.setCellValueFactory(cellData -> {
    TreeItem<Object> rowItem = cellData.getValue();
    if (rowItem != null && (rowItem.getValue() instanceof Factory)) {
        Factory f = (Factory) rowItem.getValue() ;
        return new SimpleStringProperty(f.getName());
    } else {
        return new SimpleStringProperty("");
    }
});

TreeTableColumn<Object, Number> sizeColumn = new TreeTableColumn<>("Size");
sizeColumn.setCellValueFactory(cellData -> {
    TreeItem<Object> rowItem = cellData.getValue();
    if (rowItem != null && (rowItem.getValue() instanceof Factory)) {
        Factory f = (Factory) rowItem.getValue() ;
        return new SimpleObjectProperty<Number>(Double.valueOf(f.getSize()));
    } else {
        return new SimpleObjectProperty<Number>(null);
    }
});

TreeTableColumn<Object, String> employeeColumn = new TreeTableColumn<>("Employee");
employeeColumn.setCellValueFactory(cellData -> {
    TreeItem<Object> rowItem = cellData.getValue();
    if (rowItem != null && (rowItem.getValue() instanceof Employee)) {
        Employee emp = (Employee) rowItem.getValue() ;
        return new SimpleStringProperty(emp.getName());
    } else {
        return new SimpleStringProperty("");
    }
});

treeTable.getColumns().addAll(nameColumn, sizeColumn, employeeColumn);