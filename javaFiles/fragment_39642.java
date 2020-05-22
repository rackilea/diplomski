import javax.swing.*;
import javax.swing.text.*;
import java.util.regex.*;
public class MyFilter extends DocumentFilter
{
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException
    {
        StringBuilder sb = new StringBuilder();
        sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.insert(offset, text);
        if(!containsOnlyNumbers(sb.toString())) return;
        fb.insertString(offset, text, attr);
    }
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException
    {
        StringBuilder sb = new StringBuilder();
        sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.replace(offset, offset + length, text);
        if(!containsOnlyNumbers(sb.toString())) return;
        fb.replace(offset, length, text, attr);
    }
    public boolean containsOnlyNumbers(String text)
    {
        Pattern pattern = Pattern.compile("\\d*(\\.\\d{0,3})?");
        Matcher matcher = pattern.matcher(text);
        boolean isMatch = matcher.matches();
        return isMatch;
    }
}