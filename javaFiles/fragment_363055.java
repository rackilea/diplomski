public static void setColumnOrder(int[] indices, TableColumnModel columnModel) {
    TableColumn column[] = new TableColumn[indices.length];

    for (int i = 0; i < column.length; i++) {
        column[i] = columnModel.getColumn(indices[i]);
    }

    while (columnModel.getColumnCount() > 0) {
        columnModel.removeColumn(columnModel.getColumn(0));
    }

    for (int i = 0; i < column.length; i++) {
        columnModel.addColumn(column[i]);
    }
}