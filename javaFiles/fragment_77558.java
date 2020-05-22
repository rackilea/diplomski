jt.setDefaultRenderer(Integer.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        value = hasFocus || column == 0 ? value : "";
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
});