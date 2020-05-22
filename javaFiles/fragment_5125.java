class CustomModelForTable extends AbstractTableModel {
// Code
// After creating table using model.

 TableCellRenderer defaultRenderer = tableA.getDefaultRenderer(JButton.class);
    tableA.setDefaultRenderer(JButton.class, new      JButtonRendererClass(defaultRenderer) );
// Code
}


class JButtonRendererClass implements TableCellRenderer {

private TableCellRenderer __defaultRenderer;

public JButtonRendererClass(TableCellRenderer myRenderer) {
    __defaultRenderer = myRenderer;
}

public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
    if(value instanceof Component) {
        return (Component) value;
    }
    return __defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
}
}