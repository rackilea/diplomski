int col = tab.getSelectedColumn();
int row = tab.getSelectedRow();

// Employee Processing columnindex is
if (EMPLOYEE_PROCESSING_COLUMN_INDEX == col) {
    String employeeName = (String) tab.getModel().getValueAt(row, col);