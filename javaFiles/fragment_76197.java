public void insertString(DocumentFilter.FilterBypass fb, int offset,   
    String text, AttributeSet attr) throws BadLocationException
    {
        if(!containsOnlyNumbers(text)) return;
        fb.insertString(offset, text, attr);   
    }    

    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,   
    String text, AttributeSet attr) throws BadLocationException
    {
        if(!containsOnlyNumbers(text)) return;
        fb.replace(offset, length, text, attr);
    }