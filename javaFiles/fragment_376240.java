public TableCellEditor getCellEditor(int row, int column) {
    PropertiesTableModel model = (PropertiesTableModel) getModel();
    List<Object> values = model.getPossibleValues(row, column);
    if (values != null) {
       return new DefaultCellEditor(new JComboBox(values.toArray()));
    } else {
       return super.getCellEditor(row, column);
    }
}