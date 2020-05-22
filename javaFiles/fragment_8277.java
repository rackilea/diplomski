public static class DocumentHandler implements DocumentListener {

    private MirrorDocument slaveDocument;
    private boolean ignoreUpdates = false;

    public DocumentHandler(MirrorDocument slaveDocument) {
        this.slaveDocument = slaveDocument;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        Document doc = e.getDocument();
        if (doc instanceof MirrorDocument) {
            MirrorDocument md = (MirrorDocument) doc;
            if (!md.isIgnoreUpdates()) {
                try {
                    String text = e.getDocument().getText(e.getOffset(), e.getLength());
                    slaveDocument.setIgnoreUpdates(true);
                    slaveDocument.insertString(e.getOffset(), text, null);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                } finally {
                    slaveDocument.setIgnoreUpdates(false);
                }
            }
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        Document doc = e.getDocument();
        if (doc instanceof MirrorDocument) {
            MirrorDocument md = (MirrorDocument) doc;
            if (!md.isIgnoreUpdates()) {
                try {
                    slaveDocument.setIgnoreUpdates(true);
                    slaveDocument.remove(e.getOffset(), e.getLength());
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                } finally {
                    slaveDocument.setIgnoreUpdates(false);
                }
            }
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

}