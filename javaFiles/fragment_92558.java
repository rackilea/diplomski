public static void removerows() {
    int[] row_indexes = TableCA.table.getSelectedRows();
    for(int i=row_indexes.length - 1; i >= 0; i--) {
        TableCA.model.removeRow(row_indexes[i]);
    } 
}