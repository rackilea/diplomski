import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class TestTextComponents {

    private static final long serialVersionUID = 1L;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JFrame frame = new JFrame("Default Caret");

    public TestTextComponents() {
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField1.setText("jTextField1");
        jTextField2.setText("jTextField2");
        jTextField1.setCaret(new HighlightCaret());
        jTextField2.setCaret(new HighlightCaret());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Please skip between text fields and watch persistent selection: "));
        frame.add(jTextField1);
        frame.add(jTextField2);
        frame.setTitle("Text component persistent selection");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestTextComponents();
            }
        });
    }
}

class HighlightCaret extends DefaultCaret {

    private static final Highlighter.HighlightPainter unfocusedPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
    private static final Highlighter.HighlightPainter focusedPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
    private static final long serialVersionUID = 1L;
    private boolean isFocused;

    @Override
    protected Highlighter.HighlightPainter getSelectionPainter() {
        setBlinkRate(500); // otherwise is disabled, stopped
        return isFocused ? focusedPainter/*super.getSelectionPainter()*/ : unfocusedPainter;
    }

    @Override
    public void setSelectionVisible(boolean hasFocus) {
        if (hasFocus != isFocused) {
            isFocused = hasFocus;
            super.setSelectionVisible(false);
            super.setSelectionVisible(true);
        }
    }
}