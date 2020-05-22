public class MultiplicationTableMode extends AbstractTableModel {

    private List<Integer> values;

    public MultiplicationTableMode() {
        values = new ArrayList<>(1);
        values.add(0);
    }

    @Override
    public int getRowCount() {
        return values.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public String getColumnName(int column) {
        return column == 0 ? "?" : "x" + Integer.toString(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int value = values.get(rowIndex);
        if (columnIndex > 0) {
            value *= columnIndex;
        }
        return value;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Integer.class;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            if (aValue instanceof Integer) {
                values.set(rowIndex, (int)aValue);
                fireTableRowsUpdated(rowIndex, rowIndex);
            }
        }
    }

}