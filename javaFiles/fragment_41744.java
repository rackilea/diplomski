class MyRenderer extends DefaultListCellRenderer {
   public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
      Component c = super.getListCellRendererComponent(...);
      setText(getValue(value)); // where getValue is some method you implement that gets the text you want to render for the component
      return c;
}