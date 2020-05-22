final JCheckBox checkBox = new JCheckBox();
jTable1.getColumn("Include").setCellRenderer(new DefaultTableCellRenderer() {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
      check.setSelected(((Boolean)value).booleanValue()) ;
      return check;
    }
});