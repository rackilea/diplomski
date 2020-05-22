@Override
public void insertString(FilterBypass fb, int off
                    , String str, AttributeSet attr) 
                            throws BadLocationException 
{
    // remove non-digits
    fb.insertString(off, str.replaceAll("\\D++", ""), attr);
} 
@Override
public void replace(FilterBypass fb, int off
        , int len, String str, AttributeSet attr) 
                        throws BadLocationException 
{
    // remove non-digits
    fb.replace(off, len, str.replaceAll("\\D++", ""), attr);
}