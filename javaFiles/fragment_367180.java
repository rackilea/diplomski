JList list = ... // Create JList

// Install custom renderer.
list.setCellRenderer(new DefaultListCellRenderer() {
  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

    // Request superclass to render the JLabel.
    Component ret = super.getListCellRenderer(list, value, index, isSelected, cellHasFocus);

    // Now conditionally override background if cell isn't selected.
    if (!isSelected) {
      String s = String.valueOf(value);

      if (s.equals("Foo")) {
        ret.setBackground(Color.RED);
      } else {
        ret.setBackground(Color.GREEN);
      }
    }

    return ret;
  }
});