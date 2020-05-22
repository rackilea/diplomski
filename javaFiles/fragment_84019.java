@Override
public Component getTableCellRendererComponent(JTable table,
        Object value, boolean isSelected, boolean hasFocus,
        int row, int column) {
    JComponent comp = (JComponent) originalRenderer.getTableCellRendererComponent(table, value, 
            isSelected, hasFocus, row, column);
    Border originalBorder = comp.getBorder();
    comp.setBorder(new CompoundBorderUIResource(originalBorder, 
            BorderFactory.createEmptyBorder(0, 20, 0, 0)));
    return comp;
}