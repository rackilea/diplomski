JCheckBox cb = ...
cb.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent evt) {
    updateFilters();
  }
});

JTextField tf = ...
tf.getDocument().addDocumentListener(new DocumentListener() {
  public void insertUpdate(DocumentEvent e) { updateFilters(); }
  public void removeUpdate(DocumentEvent e) { updateFilters(); }
  publci void changedUpdate(DocumentEvent e) { updateFilters(); }
});