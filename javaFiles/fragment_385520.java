class MyCellRenderer extends DefaultTableCellRenderer {

    private final TableCellRenderer old;

    MyCellRenderer(TableCellRenderer old) {
        this.old = old;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                  Object value,
                                  boolean isSelected,
                                  boolean hasFocus,
                                  int row,
                                  int column) {
        boolean levelBreak = row == 0;
        if (!levelBreak) {
            Object prior = table.getValueAt(row - 1, 0);
            Object current = table.getValueAt(row, 0);
            levelBreak = !prior.equals(current);
        }
        Component comp;
        if (old != null) {
            comp = old.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, column);
        } else {
            comp = super.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, column);
        }
        comp.setBackground(levelBreak ? Color.BLUE : Color.WHITE);
        return comp;
    }
}

table.setDefaultRenderer(Object.class, new MyCellRenderer(table.getDefaultRenderer(Object.class));