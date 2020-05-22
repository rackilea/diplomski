public void reset() {
  // for all JTextFields and JTextAreas
  for (JTextComponent textComponent: textComponentList) {
    textComponent.setText(""); 
  }

  // for all JCheckBoxes and JRadioButtons
  for (JToggleButton toggleButton: toggleButtonList) {
    toggleButton.setSelected(false);
  }

  // iterate through other lists doing likewise
}