public class CellEditorMulticaster implements TableCellEditor {
    private DefaultTableCellEditor textEditor;
    private DefaultTableCellEditor currentEditor;

    public CellEditorMulticaster() {
        firstEditor = new DefaultTableCellEditor(new JTextField());
    }

    Component getTableCellEditorComponent(JTable table, Object value,
                                      boolean isSelected,
                                      int row, int column) {
        PropertiesTableModel model = (PropertiesTableModel) table.getModel();
        List<Object> values = model.getPossibleValues(row, column);
        if (values != null) {
            currentEditor = new DefaultCellEditor(new JComboBox(values.toArray()));
        } else {
            currentEditor = textEditor;
        }
        return currentEditor.getTableCellEditorComponent(table, value,
               isSelected, row, column);
    }

    public Object getCellEditorValue() {
        return currentEditor.getCellEditorValue();
    }

    public boolean isCellEditable(EventObject anEvent) {
        JTable table = (JTable) anEvent.getSource;
        int row, col;
        if (anEvent instanceof MouseEvent) {
            MouseEvent evt = (MouseEvent) anEvent;
            row = table.rowAtPoint(evt.getPoint());
            col = table.columnAtPoint(evt.getPoint());
        } else {
            row = table.getSelectedRow();
            col = table.getSelectedColumn();
        }
        PropertiesTableModel model = (PropertiesTableModel) table.getModel();
        List<Object> values = model.getPossibleValues(row, column);
        if (values != null) {
            return true;
        } else {
            return textEditor.isCellEditable(anEvent);
        }
    }

    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    public boolean stopCellEditing() {
        return currentEditor.stopCellEditing();
    }

    public void  cancelCellEditing() {
        currentEditor.cancelCellEditing();
    }

    // same pattern for another methods (delegate to currentEditor)
}