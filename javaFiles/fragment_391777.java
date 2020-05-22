public boolean selectRow(int attemptId) {
    MyTableModel tableModel = (MyTableModel) dataSearchResultTable.getModel();
    int row = 0;
    if (attemptId >= 0 && attemptId < tableModel.getRowCount()) {
        System.out.println("rowToSelect=" + row);
        dataSearchResultTable.setRowSelectionInterval(attemptId, attemptId);
        dataSearchResultTable.setColumnSelectionInterval(2, 2);
        tableModel.fireTableCellUpdated(row, 2);
        dataSearchResultTable.requestFocusInWindow();
        row = dataSearchResultTable.getSelectedRow();
        if(row != -1){
            dataSearchResultTable.editCellAt(row, 2);
        }
        return true;
    }
    return false;
}