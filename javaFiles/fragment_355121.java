protected void removeRows(final int[] rows) {
    int modelRows[] = new int[rows.length];
    for(int i = 0; i < rows.length; ++i) {
        modelRows[i] = table.convertRowIndexToModel(rows[i]);
    }
    Arrays.sort(modelRows);
    for(int i = modelRows.length - 1; i >= 0; --i) {
        int row = modelRows[i];
        model.removeRow(row);
    }
    model.fireTableDataChanged();
}