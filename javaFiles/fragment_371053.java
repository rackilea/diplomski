private void refresh() {
    if (table.isEditing()) {
        int row = table.getEditingRow();
        int column = table.getEditingColumn();
        table.getCellEditor(row, column).stopCellEditing();
    }
 ...