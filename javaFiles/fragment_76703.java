public class GridlineCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent (
        JTable table,
        Object value,
        boolean isSelected,
        boolean hasFocus,
        int row,
        int column
    ) {
        final Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if ( row == 0 && (column == 0 || column ==1 ) {
            cell.setBackground( Color.RED );
        }
        return cell;
    }
}