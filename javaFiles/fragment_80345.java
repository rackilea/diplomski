TreeTableView<EmploymentEntity> treeTable = new TreeTableView<>();
TreeTableColumn<EmploymentEntity, String> nameColumn = new TreeTableColumn<>("Name");
nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue().getName()));
TreeTableColumn<EmploymentEntity, Number> sizeColumn = new TreeTableColumn<>("Size");
sizeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<Number>(cellData.getValue().getValue().getSize()));
TreeTableColumn<EmploymentEntity, String> employeeColumn = new TreeTableColumn<>("Employee");
employeeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue().getEmployeeName()));
// etc...