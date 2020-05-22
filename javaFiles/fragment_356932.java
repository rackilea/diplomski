/**
  * holder for boolean variable to be passed as reference
  */
private static class BoolContainer {
    boolean value;
}

public static <T> void createSortBinding(TableView<T> table1, TableView<T> table2) {
    final int count = table1.getColumns().size();
    if (table2.getColumns().size() != count) {
        throw new IllegalArgumentException();
    }

    // bind sort types
    for (int i = 0; i < count; i++) {
        table1.getColumns().get(i).sortTypeProperty().bindBidirectional(
                table2.getColumns().get(i).sortTypeProperty());
    }

    BoolContainer container = new BoolContainer();
    bindList(table1, table2, container);
    bindList(table2, table1, container);
}

/**
  * helper for one direction of the binding of the source orders
  */
private static <T> void bindList(TableView<T> table1,
        TableView<T> table2,
        BoolContainer modifyingHolder) {

    ObservableList<TableColumn<T, ?>> sourceColumns = table1.getColumns();
    ObservableList<TableColumn<T, ?>> sourceSortOrder = table1.getSortOrder();
    ObservableList<TableColumn<T, ?>> targetColumns = table2.getColumns();
    ObservableList<TableColumn<T, ?>> targetSortOrder = table2.getSortOrder();

    // create map to make sort order independent form column order
    Map<TableColumn<T, ?>, TableColumn<T, ?>> map = new HashMap<>();
    for (int i = 0, size = sourceColumns.size(); i < size; i++) {
        map.put(sourceColumns.get(i), targetColumns.get(i));
    }

    sourceSortOrder.addListener((Observable o) -> {
        if (!modifyingHolder.value) {
            modifyingHolder.value = true;

            // use map to get corresponding sort order of other table
            final int size = sourceSortOrder.size();
            TableColumn<T, ?>[] sortOrder = new TableColumn[size];

            for (int i = 0; i< size; i++) {
                sortOrder[i] = map.get(sourceSortOrder.get(i));
            }
            targetSortOrder.setAll(sortOrder);

            modifyingHolder.value = false;
        }
    });
}