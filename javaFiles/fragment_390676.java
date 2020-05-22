if (table.isEditing()) {
    boolean stopped = table.getCellEditor().stopCellEditing();
    if (!stopped) {
        // here goes error handling and/or cancelling the edit
    }
}