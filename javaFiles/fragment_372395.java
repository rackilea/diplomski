class TableModel extends AbstractTableModel {
    Object[][] innerModel = new Object[][]{{2, 1}, {2, null}};

    public TableModel() {

    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return innerModel.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return innerModel[row][col];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        innerModel[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

}