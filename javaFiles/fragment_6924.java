model = new DefaultTableModel(rows, columns) {
    private static final long serialVersionUID = 1L;

    public Class<? extends Object> getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    @Override
    public void setValueAt(Object object, int row, int column) {
        int changedValue = ((Integer) object).intValue();
        if (column == 2) {
            super.setValueAt(300 - changedValue, row, column + 1);
        } else if (column == 3) {
            super.setValueAt(300 - changedValue, row, column - 1);
       }
       super.setValueAt(object, row, column);
    }
};