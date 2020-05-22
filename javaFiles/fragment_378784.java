private static class MyCellEditor extends AbstractCellEditor implements TableCellEditor {

    DefaultCellEditor other = new DefaultCellEditor(new JTextField());
    DefaultCellEditor checkbox = new DefaultCellEditor(new JComboBox(new Object[] {"abc"}));

    private DefaultCellEditor lastSelected;

    @Override
    public Object getCellEditorValue() {

        return lastSelected.getCellEditorValue();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
        if(row == 0) {
            lastSelected = checkbox;
            return checkbox.getTableCellEditorComponent(table, value, isSelected, row, column);
        }
        lastSelected = other;
        return other.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

}