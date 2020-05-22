textField.getDocument().addDocumentListener(new DocumentListener() {
    public void insertUpdate(DocumentEvent e) {
        // search the prediction data for the current contents 
        // of the text field
    }
    public void removeUpdate(DocumentEvent e) {
        // do stuff
    }
    public void changedUpdate(DocumentEvent e) {
        //Plain text components do not fire these events
    }
});