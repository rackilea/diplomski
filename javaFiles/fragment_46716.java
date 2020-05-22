DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
};
JTable table = new JTable(model);