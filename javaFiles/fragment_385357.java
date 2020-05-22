private class NoSpaceField extends TextField {

    public void replaceText(int start, int end, String text) {
        String old = getText();
        if (text.matches("[A-Za-z0-9]*")) {
            super.replaceText(start, end, text);
        }
        if (getText().length() > 16)
            setText(old);
        positionCaret(getText().length());
    }

    public void replaceSelection(String text) {
        String old = getText();
        if (text.matches("[A-Za-z0-9]*")) {
            super.replaceSelection(text);
        }
        if (getText().length() > 16)
            setText(old);
        positionCaret(getText().length());
    }
}