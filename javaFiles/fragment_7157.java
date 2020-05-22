// Listen for changes in the text
textField.getDocument().addDocumentListener(new DocumentListener() {
  public void changedUpdate(DocumentEvent e) {
    warn();
  }
  public void removeUpdate(DocumentEvent e) {
    warn();
  }
  public void insertUpdate(DocumentEvent e) {
    warm();
  }

  public void warn() {
     // fire the execute statement.
  }
});