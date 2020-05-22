private static TableCellRenderer getRenderer() {
return new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
            boolean solved = false;
            if (value.toString().endsWith("Solved")) {
                solved = true;
                value = value.toString().replace("Solved", "");
            }
            Component tableCellRendererComponent = super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
            if (solved) {
                tableCellRendererComponent.setBackground(Color.GREEN);
            } else {
                tableCellRendererComponent.setBackground(table.getBackground());
            }
            return tableCellRendererComponent;
    }
};
}