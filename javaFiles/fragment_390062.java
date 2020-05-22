table.skinProperty().addListener((obs, oldSkin, newSkin) -> {
    final TableHeaderRow header = (TableHeaderRow) table.lookup("TableHeaderRow");
    header.reorderingProperty().addListener((o, oldVal, newVal) -> {
        ObservableList columns = table.getColumns();

        // If the first columns is not in the first index change it
        if (columns.indexOf(firstNameCol) != 0) {
                columns.remove(firstNameCol);
                columns.add(0, firstNameCol);
            }
        // Use the same logic for the last column
        if (columns.indexOf(phoneCol) != columns.size() - 1) {
            columns.remove(phoneCol);
            columns.add(columns.size() , phoneCol);
        }
    });
});