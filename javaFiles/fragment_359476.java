class MyDocumentListener implements DocumentListener {
    String newline = "\n";

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateLog(e, "inserted into");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateLog(e, "removed from");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        //Plain text components do not fire these events
    }

    public void updateLog(DocumentEvent e, String action) {
        Document doc = (Document)e.getDocument();
        int changeLength = e.getLength();
        displayArea.append(
            changeLength + " character" +
            ((changeLength == 1) ? " " : "s ") +
            action + doc.getProperty("name") + "." + newline +
            "  Text length = " + doc.getLength() + newline);
    }
}