public Component getTableCellEditorComponent(JTable table,
        Object value, boolean isSelected, int row, int column) {


    buttonValue = (value == null) ? "" : value.toString();
    toggle.setText(buttonValue);


    return toggle;
}