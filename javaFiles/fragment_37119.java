DefaultTableModel myModel = new DefaultTableModel(...) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}