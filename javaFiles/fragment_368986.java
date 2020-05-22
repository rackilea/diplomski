final JComboBox combo = new JComboBox(items);
TableColumn col = table.getColumnModel().getColumn(ITEM_COL);
col.setCellRenderer(new DefaultTableCellRenderer(){

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table,
            value, isSelected, hasFocus, row, column);
        label.setIcon(UIManager.getIcon("Table.descendingSortIcon"));
        return label;
    }
});