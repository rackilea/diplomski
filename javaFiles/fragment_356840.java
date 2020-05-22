@SuppressWarnings("serial")
class BooleanStringEditor extends AbstractCellEditor implements TableCellEditor {
   private JTextField textField = new JTextField();

   public BooleanStringEditor() {
      PlainDocument doc = (PlainDocument) textField.getDocument();
      doc.setDocumentFilter(new MyDocFilter());
   }

   @Override
   public Object getCellEditorValue() {
      if (textField.getText().equalsIgnoreCase("t")) {
         return Boolean.TRUE;
      } else if (textField.getText().equalsIgnoreCase("f")) {
         return Boolean.FALSE;
      }
      // default if user messes up
      return null;
   }

   @Override
   public Component getTableCellEditorComponent(JTable table, Object value,
         boolean isSelected, int row, int column) {
      Boolean boolValue = (Boolean) value;
      if (boolValue == null) {
         textField.setText("");
      } else if (boolValue) {
         textField.setText("T");
      } else {
         textField.setText("F");
      }
      return textField;
   }

}

class MyDocFilter extends DocumentFilter {

   private boolean test(String text) {
      if (text.isEmpty()) {
         return true;
      }
      if (text.equalsIgnoreCase("t") || text.equalsIgnoreCase("f")) {
         return true;
      }
      return false;
   }

   @Override
   public void insertString(FilterBypass fb, int offset, String string,
         AttributeSet attr) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.insert(offset, string);

      if (test(sb.toString())) {
         super.insertString(fb, offset, string, attr);
      } else {
         // warn the user and don't allow the insert
      }
   }

   @Override
   public void replace(FilterBypass fb, int offset, int length, String text,
         AttributeSet attrs) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.replace(offset, offset + length, text);

      if (test(sb.toString())) {
         super.replace(fb, offset, length, text, attrs);
      } else {
         // warn the user and don't allow the insert
      }

   }

   @Override
   public void remove(FilterBypass fb, int offset, int length)
         throws BadLocationException {
      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.delete(offset, offset + length);

      if (test(sb.toString())) {
         super.remove(fb, offset, length);
      } else {
         // warn the user and don't allow the insert
      }

   }
}