table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table,
                                  Object value,
                                  boolean isSelected,
                                  boolean hasFocus,
                                  int row,
                                  int column) {
        Component comp = super.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, column);
        if(!isSelected) { //Important check, see comment below!
            boolean levelBreak = row == 0;
            if (!levelBreak) {
                Object prior = table.getValueAt(row - 1, 0);
                Object current = table.getValueAt(row, 0);
                levelBreak = !prior.equals(current);
            }
            comp.setBackground(levelBreak ? Color.BLUE : Color.WHITE);
        }
        return comp;
    }
});