DefaultTableModel model = (DefaultTableModel)roomtable.getModel();
int row = 0;
while (row < model.getRowCount()) {
    if ((model).getValueAt(row, 1).equals("Single")) {
        model.removeRow(row);
    } else {
        row++;
    }
}