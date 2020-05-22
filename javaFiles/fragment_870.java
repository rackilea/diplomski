private class TableFilterHeader extends JPanel {
    public TableFilterHeader(JTableHeader th) {
        setLayout(new BorderLayout());
        add(new TableFilterRow(th.getTable()), BorderLayout.SOUTH);
    }
}