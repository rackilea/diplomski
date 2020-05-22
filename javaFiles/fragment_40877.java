public void actionPerformed(ActionEvent evt) {
  // the 'current' selection state, i.e. what it is going to be after the event
  boolean selected = ((JCheckBoxMenuItem)evt.getSource()).isSelected();
  String library = evt.getActionCommand();
  ... process based on library and state here...
}