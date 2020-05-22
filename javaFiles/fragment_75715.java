private class ExtendedTableCellEditor extends AbstractCellEditor implements TableCellEditor
{
  JLabel _component = new JLabel();
  JScrollPane _pane = new JScrollPane(_component, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

 /**
  * Returns the cell editor component.
  *
  */
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex)
  {
    if (value == null) return null;
    _component.setText(value != null ? value.toString() : "");
    _component.setToolTipText(value != null ? value.toString() : "");

    _component.setOpaque(true);
    _component.setBackground((isSelected) ? Color.BLUE_DARK : Color.WHITE);
    _component.setForeground((isSelected) ? Color.WHITE : Color.BLACK);

    _pane.setHorizontalScrollBar(_pane.createHorizontalScrollBar()); 
    _pane.setVerticalScrollBar(_pane.createVerticalScrollBar());
    _pane.setBorder(new EmptyBorder(0,0,0,0));
    _pane.setToolTipText(value != null ? value.toString() : "");
    return _pane;
  }
  public Object getCellEditorValue()
  {
    return _component.getText();
  }
}