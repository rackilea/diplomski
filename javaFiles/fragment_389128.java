class ButtonEditor extends DefaultCellEditor {
   protected JButton button;
   private String label;
   private boolean isPushed;
   private int myRow;  // *******added **********

   public ButtonEditor(JCheckBox checkBox) {
      // ..............
   }

   @Override
   public Component getTableCellEditorComponent(JTable table, Object value,
         boolean isSelected, int row, int column) {
      this.myRow = row;  // *******added **********
      if (isSelected) {
         button.setForeground(table.getSelectionForeground());
         button.setBackground(table.getSelectionBackground());
      } else {
         button.setForeground(table.getForeground());
         button.setBackground(table.getBackground());
      }
      label = (value == null) ? "" : value.toString();
      button.setText(label);
      isPushed = true;
      return button;
   }

   @Override
   public Object getCellEditorValue() {
      if (isPushed) {
         // can get the row number here
         JOptionPane.showMessageDialog(button, label + ": Ouch! " + myRow);
      }
      isPushed = false;
      return new String(label);
   }