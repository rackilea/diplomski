JTextArea.getDocument().addDocumentListener(new DocumentListener() {
  public void changedUpdate(DocumentEvent e) {
    check();
  }
  public void removeUpdate(DocumentEvent e) {
    check();
  }
  public void insertUpdate(DocumentEvent e) {
    check();
  }

  public void check() {
     if (JTextArea.getLineCount()>4){//make sure no more than 4 lines
       JOptionPane.showMessageDialog(null, "Error: Cant have more than 4 lines", JOptionPane.ERROR_MESSAGE);
     }
  }
});