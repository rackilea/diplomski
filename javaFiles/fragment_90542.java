class MyDocFilter extends DocumentFilter {
    private static final List<String> BAD_TEXTS = Arrays.asList("...", "   ", "oops", "OOPS");

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        StringBuilder sb = new StringBuilder(currentText);

        String newText = sb.insert(offset, string).toString();

        if (isTextOk(newText)) {
            super.insertString(fb, offset, string, attr);
        } else {
            badText(fb);
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        StringBuilder sb = new StringBuilder(currentText);

        String newText = sb.replace(offset, offset + length, "").toString();

        if (isTextOk(newText)) {
            super.remove(fb, offset, length);
        } else {
            badText(fb);
        }

    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        StringBuilder sb = new StringBuilder(currentText);

        String newText = sb.replace(offset, offset + length, text).toString();

        if (isTextOk(newText)) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            badText(fb);
        }

    }

    private boolean isTextOk(String text) {
        return !BAD_TEXTS.contains(text);
    }

    private void badText(FilterBypass fb) throws BadLocationException {
        remove(fb, 0, fb.getDocument().getLength());
        JOptionPane.showMessageDialog(null, "Don't do this!", "Bad Text Entered",
                JOptionPane.WARNING_MESSAGE);
    }

}