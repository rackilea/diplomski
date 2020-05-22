JTable jt = new JTable(data, column) {
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return Integer.class;
    }
};