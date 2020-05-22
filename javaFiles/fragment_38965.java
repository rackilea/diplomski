import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class DefaultCaretTest extends JFrame
{
    public DefaultCaretTest()
    {
        JTextField textField1 = new JTextField("Text Field1   ");
        JTextField textField2 = new JTextField("Text Field2   ");

        textField1.setCaret(new SelectionCaret());
        textField2.setCaret(new SelectionCaret());

        textField1.select(5, 11);
        textField2.select(5, 11);
        ((DefaultCaret)textField2.getCaret()).setSelectionVisible(true);

        add(textField1, BorderLayout.WEST);
        add(textField2, BorderLayout.EAST);
    }

    static class SelectionCaret extends DefaultCaret
    {
        public SelectionCaret()
        {
            setBlinkRate( UIManager.getInt("TextField.caretBlinkRate") );
        }

        public void focusGained(FocusEvent e)
        {
            setVisible(true);
            setSelectionVisible(true);
        }

        public void focusLost(FocusEvent e)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        DefaultCaretTest frame = new DefaultCaretTest();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}