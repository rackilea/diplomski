public class CustomTableCellRenderer implements TableCellRenderer {

    private final TableCellRenderer decorate;

    public CustomTableCellRenderer(final TableCellRenderer decorate) {
        super();
        this.decorate = decorate;
    }

    public Component getTableCellRendererComponent(final JTable table, final Object value,
            final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        if (column == 0 && row == table.getRowCount() - 1) {
            return null;
        }
        return decorate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}