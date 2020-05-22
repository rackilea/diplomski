import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JEditorPane editorPane;

        public TestPane() {
            editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setText("<html>Hello world, this is a test</html>");
            setLayout(new BorderLayout());
            add(new JScrollPane(editorPane));

            editorPane.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Point point = e.getPoint();
                    Range range = getRangeOfWordUnderMouse(editorPane, point);
                    //String word = getWordUnderMouse(editorPane, point);
                    SimpleAttributeSet as = new SimpleAttributeSet();
                    StyleConstants.setUnderline(as, true);
                    ((StyledDocument)editorPane.getDocument()).setCharacterAttributes(range.getFrom(), range.length(), as, false);
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public static class Range {
        private int from;
        private int to;

        public Range(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int length() {
            return to - from;
        }

    }

    public static Range getRangeOfWordUnderMouse(JTextComponent textComp, Point2D point) {
        int pos = textComp.viewToModel2D(point);
        try {
            Document doc = textComp.getDocument();
            if (pos > 0 && (pos >= doc.getLength() || Character.isWhitespace(doc.getText(pos, 1).charAt(0)))) {
                // if the next character is a white space then use 
                // the word on the left side..
                pos--;
            }
            // get the word from current position
            final int begOffs = Utilities.getWordStart(textComp, pos);
            final int endOffs = Utilities.getWordEnd(textComp, pos);

            return new Range(begOffs, endOffs);
        } catch (BadLocationException ex) {
            // Ignore this exception!!!
            ex.printStackTrace();
        }
        return null;
    }

    public static String getWordUnderMouse(JTextComponent textComp, Point2D point) {
        Range range = getRangeOfWordUnderMouse(textComp, point);
        if (range == null) {
            return "";
        }

        try {
            return textComp.getText(range.getFrom(), range.length());
        } catch (BadLocationException ex) {
            ex.printStackTrace();;
        }
        return "";
    }

}