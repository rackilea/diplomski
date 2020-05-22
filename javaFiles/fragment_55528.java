class CustomDocument extends PlainDocument {
    @Override
    public void insertString(int offset, String string, AttributeSet attributeSet)
            throws BadLocationException {
        // Do something here
        super.insertString(offset, string, attributeSet);
    }
}