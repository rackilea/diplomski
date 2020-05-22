public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    setText(value.toString());
    if (row==12 && column==2) {
        setBackground(Color.RED);
    }
    return this;
}