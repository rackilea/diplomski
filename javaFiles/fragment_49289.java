JTextField componentTextField;
componentTextField.getDocument().addDocumentListener(new DocumentListener() {

    protected void generateTextEvent(DocumentEvent e) {
        try {
            Document doc = e.getDocument();
            generateTextEvent(doc.getText(0, doc.getLength()));
        } catch (BadLocationException ex) {
            // Handle possible exception
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        generateTextEvent(e);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        generateTextEvent(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        generateTextEvent(e);
    }
});