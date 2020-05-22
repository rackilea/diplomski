import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class SelectionCaret extends DefaultCaret
{
    private final Highlighter.HighlightPainter unfocusedPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
    private final Highlighter.HighlightPainter focusedPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.ORANGE);

    public SelectionCaret()
    {
        setBlinkRate( UIManager.getInt("TextField.caretBlinkRate") );
    }

    @Override
    protected Highlighter.HighlightPainter getSelectionPainter()
    {
        return getComponent().hasFocus() ? focusedPainter : unfocusedPainter;
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        setSelectionVisible(false);
        super.focusGained(e);
    }

    @Override
    public void focusLost(FocusEvent e)
    {
        super.focusLost(e);
        setSelectionVisible(true);
    }

    private static void createAndShowUI()
    {
        JTextField textField1 = new JTextField("Text Field1   ");
        JTextField textField2 = new JTextField("Text Field2   ");
        JTextField textField3 = new JTextField("Non Editable   ");
        textField3.setEditable(false);

        textField1.setCaret(new SelectionCaret());
        textField2.setCaret(new SelectionCaret());
        textField3.setCaret(new SelectionCaret());

        textField1.select(5, 11);
        textField2.select(5, 11);
        textField3.select(5, 11);
        ((DefaultCaret)textField1.getCaret()).setSelectionVisible(true);
        ((DefaultCaret)textField2.getCaret()).setSelectionVisible(true);
        ((DefaultCaret)textField3.getCaret()).setSelectionVisible(true);

        JPanel north = new JPanel();
        north.add( new JTextField("Text Field0   ") );
        north.add(textField1);
        north.add(textField2);
        north.add(textField3);

        JFrame frame = new JFrame("Selection Caret");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( north );
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}