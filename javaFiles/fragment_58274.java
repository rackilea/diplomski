import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
public class FilterTextField
{
    public static void main (String [] a) {
        SwingUtilities.invokeLater (new Runnable () {
            @Override public void run () {
                createAndShowGUI ();
            }
        });
    }
    private static void createAndShowGUI () {
        JFrame frame = new JFrame ("Test");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setContentPane (new MainPanel ());
        frame.pack ();
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
    }
}
class MainPanel extends JPanel
{
    public MainPanel () {
        super (new GridLayout (3, 1, 0, 20));

        JTextField t1 = new JTextField (20);
        JTextField t2 = new JTextField (20);
        JTextField t3 = new JTextField (20);

        ((AbstractDocument) t1.getDocument ()).setDocumentFilter (new MyDocumentFilter (5));
        ((AbstractDocument) t2.getDocument ()).setDocumentFilter (new MyDocumentFilter (10, '!', '?'));
        ((AbstractDocument) t3.getDocument ()).setDocumentFilter (new MyDocumentFilter (15, new char [] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}));

        add (t1);
        add (t2);
        add (t3);

        setBorder (new EmptyBorder (20, 20, 20, 20));
    }


}
class MyDocumentFilter extends DocumentFilter
{
    private char [] forbiddenCharacters;
    private int maximumLength;

    public MyDocumentFilter (int maximumLength, char ... forbiddenCharacters) {
        this.maximumLength = maximumLength;
        this.forbiddenCharacters = forbiddenCharacters;
    }
    @Override public void replace (FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        // Get the full text you would have after replacement
        Document document = fb.getDocument ();
        String fullText = new StringBuilder (document.getText (0, document.getLength ())).replace (offset, offset + length, text).toString ();
        // Check your requirements ...
        if (fullText.length () <= maximumLength) {
            if (forbiddenCharacters != null) {
                for (char c : forbiddenCharacters) if (fullText.indexOf (c) > -1) return;
            }
            // Replace method is called only if your requirements are met.
            super.replace (fb, offset, length, text, attrs);
        }
    }
}