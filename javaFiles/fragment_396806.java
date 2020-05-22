public class PaintTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, "", isSelected, hasFocus, row, column);
        if (value instanceof Double) {
            double distance = (double) value;
            int part = (int) (255 * distance);
            Color color = new Color(part, part, part);
            setBackground(color);
        } else {
            setBackground(Color.WHITE);
        }
        return this;
    }

}