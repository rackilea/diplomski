textFieldA.getDocument().addDocumentListener(new DocumentListener() {
  @Override
  public void removeUpdate (DocumentEvent e) {
    blockA = true;
    if (!blockB) textFieldB.setText(textFieldA.getText());
    blockA = false;
  }
  @Override
  public void insertUpdate (DocumentEvent e) {
    blockA = true;
    if (!blockB) textFieldB.setText(textFieldA.getText());
    blockA = false;
  }
  @Override
  public void changedUpdate (DocumentEvent e) {
    blockA = true;
    if (!blockB) textFieldB.setText(textFieldA.getText());
    blockA = false;
  }
});