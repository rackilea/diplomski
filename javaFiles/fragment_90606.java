jTextArea1.setEditable(false);

jTextField1.getDocument().addDocumentListener(new DocumentListener() {

    public void insertUpdate(DocumentEvent de) {
        jTextArea1.setText(s);
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        jTextArea1.setText(s);
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        //Plain text components don't fire these events.
    }
});