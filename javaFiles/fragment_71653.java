class GrayWhiteRenderer extends DefaultTableCellRenderer {
    private int rowToColored;

    GrayWhiteRenderer(int rowToColored) {
        this.rowToColored = rowToColored;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // As I know there is no value is registered for "table.row" in UIManager
        // so I've skipped the first condition
        if (row == rowToColored) {
            c.setBackground(Color.GRAY.brighter());
        } else {
            // use correct color depended on whether the cell is selected or not!
            c.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        }
        return c;
    }
}