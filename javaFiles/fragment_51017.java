import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

public class MultiHighlight implements ActionListener {

    private JTextComponent comp;
    private String charsToHighlight;

    public MultiHighlight(JTextComponent c, String chars) {
        comp = c;
        charsToHighlight = chars;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Highlighter h = comp.getHighlighter();
        h.removeAllHighlights();
        String text = comp.getText().toUpperCase();
        for (int j = 0; j < text.length(); j += 1) {
            char ch = text.charAt(j);
            if (charsToHighlight.indexOf(ch) >= 0) {
                try {
                    h.addHighlight(j, j + 1, DefaultHighlighter.DefaultPainter);
                } catch (BadLocationException ble) {
                }
            }
        }
    }

    public static void main(String args[]) {
        final JFrame frame = new JFrame("MultiHighlight");
        frame.add(new JTextField("Another focusable JComponents"), BorderLayout.NORTH);
        JTextArea area = new JTextArea(10, 20);
        area.setText("This is the story\nof the hare who\nlost his spectacles."
                + "\nThis is the story\nof the hare who\nlost his spectacles.");
        frame.getContentPane().add(new JScrollPane(area), BorderLayout.CENTER);
        JButton b = new JButton("Highlight All Vowels");
        b.addActionListener(new MultiHighlight(area, "aeiouAEIOU"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(b, BorderLayout.SOUTH);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}