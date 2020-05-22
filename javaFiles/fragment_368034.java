@Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
    {
        if(fb.getDocument().getLength()+text.length()>numberOfLetters)
        {
            return;
        }

        super.insertString(fb, offset, text, attrs);
    }