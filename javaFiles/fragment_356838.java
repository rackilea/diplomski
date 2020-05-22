public class BooleanEditor extends AbstractCellEditor implements TableCellEditor {

   JComboBox<Boolean> combo = new JComboBox<Boolean>(new Boolean[] {
         Boolean.TRUE, Boolean.FALSE });

   public BooleanEditor() {
      combo.setRenderer(new DefaultListCellRenderer() {
         @Override
         public Component getListCellRendererComponent(JList<?> list,
               Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Boolean boolValue = (Boolean) value;
            String displayString = "";
            if (boolValue == null) {
               displayString = "";
            } else if (boolValue) {
               displayString = "T";
            } else {
               displayString = "F";
            }
            return super.getListCellRendererComponent(list, displayString,
                  index, isSelected, cellHasFocus);
         }
      });
   }

   @Override
   public Object getCellEditorValue() {
      return combo.getSelectedItem();
   }

   @Override
   public Component getTableCellEditorComponent(JTable table, Object value,
         boolean isSelected, int row, int column) {
      if (value == null) {
         combo.setSelectedIndex(-1);
      } else {
         combo.setSelectedItem((Boolean) value);
      }
      return combo;
   }
}