Object[] columnNames = { "A", "B", "C", "D" };
Object[][] data = { 
        { "abc", new Double(850.503), 53, true },
        { "lmn", new Double(36.23254), 6, false }, 
        { "pqr", new Double(8.3), 7, false },
        { "xyz", new Double(246.0943), 23, true } };

JTable table = new JTable(data, columnNames) {
    @Override
    public java.awt.Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
        java.awt.Component comp = super.prepareRenderer(renderer, row, col);
        Object value = getModel().getValueAt(row, 0);
        if (value.equals("lmn")) {
            comp.setBackground(Color.lightGray);
        }  else {
           comp.setBackground(Color.white);
        }
        return comp;
    }
};