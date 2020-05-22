ObservableList<TreeItem<Person>> tables = FXCollections.observableArrayList();
for (int i = 0; i < table.getExpandedItemCount(); i++) {
    tables.add(table.getTreeItem(0));
}

FXCollections.sort(tables,comparator);
if (tables.size()>0) {
    table.getRoot().getChildren().setAll(tables);
}