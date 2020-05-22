int[] columns = jtable.getSelectedColumns();
TableModel model = jtable.getModel();
int rowcount = model.getRowCount();
String[][] output = new String[columns.length][rowcount];
for (int i = 0; i < columns.length; i++)
    for (int row = 0; row < rowcount; row++){
        int column = jtable.convertColumnIndexToModel(columns[i]);
        output[i][row] = model.getValueAt(row, column).toString();
    }