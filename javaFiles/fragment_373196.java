public class CustomTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
                    Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(
                        table, obj, isSelected, hasFocus, row, column);

        TableModel model = table.getModel();
        int money = (int) model.getValueAt(row, 1);
        int min = (int)model.getValueAt(row, 2);

        if (money < min) {
            cell.setBackground(Color.cyan);
        } else {
            cell.setBackground(Color.lightGray);
        }

        return cell;
    }
}