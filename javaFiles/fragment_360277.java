ObservableList<TextFile> files = ...;
TableView<TextFile> table = new TableView<>();
table.setItems(files);

TableColumn<TextFile, String> nameCol = new TableColumn<>("Name");
nameCol.setCellValueFactory(features -> features.getValue().nameProperty());
table.getColumns().add(nameCol);

TableColumn<TextFile, Number> sizeCol = new TableColumn<>("Size");
sizeCol.setCellValueFactory(features -> features.getValue().sizeProperty());
table.getColumns().add(sizeCol);