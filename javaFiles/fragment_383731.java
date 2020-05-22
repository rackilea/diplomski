import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
public class Test
{
    public static void main (String [] a) {
        SwingUtilities.invokeLater (new Runnable () {
            public void run () {
                createAndShowGUI ();
            }
        });
    }
    private static void createAndShowGUI () {
        // Creating JTextField
        JTextField textField = new JTextField (5);
        ((AbstractDocument) textField.getDocument ()).setDocumentFilter (new CustomDocumentFilter ());
        // Creating example frame
        JFrame frame = new JFrame ("Test");
        JPanel contentPane = new JPanel (new FlowLayout (FlowLayout.CENTER, 75, 50));
        contentPane.add (textField);
        frame.setContentPane (contentPane);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack ();
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
    }
}
class CustomDocumentFilter extends DocumentFilter
{
    @Override public void replace (FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        String textAfterReplacement = new StringBuilder (fb.getDocument ().getText (0, fb.getDocument ().getLength ())).replace (offset, offset + length, text).toString ();
        try {
            int value = Integer.parseInt (textAfterReplacement);
            if (value < 0) value = 0;
            else if (value > 255) value = 255;
            super.replace (fb, 0, fb.getDocument ().getLength (), String.valueOf (value), attrs);
        }
        catch (NumberFormatException e) {
            // Handle exception ...
        }
    }
}