JFrame frame = new JFrame("Summation of 2 columns");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Object rows[][] = { { 100, 200 } };

String columns[] = { "Column 1", "Column 2" };

JTable table = new JTable(new DefaultTableModel(rows, columns) {
    private static final long serialVersionUID = 1L;

    public Class<? extends Object> getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    @Override
    public void setValueAt(Object object, int row, int column) {
        int changedValue = ((Integer) object).intValue();
        if (column == 0) {
            super.setValueAt(300 - changedValue, row, column + 1);
        } else if (column == 1) {
            super.setValueAt(300 - changedValue, row, column - 1);
        }
        super.setValueAt(object, row, column);
    }
});

JScrollPane pane = new JScrollPane(table);

frame.add(pane, BorderLayout.CENTER);

frame.setSize(200, 150);
frame.setVisible(true);