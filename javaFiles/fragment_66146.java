private DocumentListener docListener = new DocumentListener() {

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        printIt(documentEvent);
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        printIt(documentEvent);
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        printIt(documentEvent);
    }

    private void printIt(DocumentEvent documentEvent) {
        DocumentEvent.EventType type = documentEvent.getType();
        //your code
    }
};