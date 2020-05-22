public class JScrollTableEditor extends AbstractCellEditor implements TableCellEditor {
    JScrollPane component = new JScrollPane();
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
          int rowIndex, int vColIndex)
    {
        component = ((JScrollPane) value);
        return ((JScrollPane) value);
    }

    public Object getCellEditorValue()
    {
        return component;
    }

    }