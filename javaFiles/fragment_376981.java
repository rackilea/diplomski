public Component getTableCellEditorComponent(
JTable table, Object value, boolean isSelected, int row, int column) {
  ...
  editButton.setText( value.toString() );
  editButton.setIcon( null );
  ...
}