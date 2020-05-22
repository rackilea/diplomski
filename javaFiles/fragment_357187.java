import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class TextAreaTest extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextArea textArea;

    public TextAreaTest() {
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(60, 32));
        textArea.setOpaque(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(new DocumentFilter() {

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                string = string.replaceAll("\\{", "\\{}");
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                text = text.replaceAll("\\{", "\\{}");
                //TODO must do something here
                super.replace(fb, offset, length, text, attrs);
            }
        });

        textArea.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                update(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update(e);
            }

            private void update(DocumentEvent e) {
                List<String> lines = getLines(textArea);
                String lastLine = lines.get(lines.size() - 1);
                int tabbedTextWidth = Utilities.getTabbedTextWidth(new Segment(
                        lastLine.toCharArray(), 0, lastLine.length()), textArea.getFontMetrics(textArea.getFont()), 0, null, 0);
                int lineHeight = getLineHeight(textArea);
                if (lines.size() * lineHeight > textArea.getHeight() || tabbedTextWidth > textArea.getWidth()) {
                    System.out.println("Too big! Should refuse the update!");
                }
            }
        });

        getContentPane().add(textArea);
    }

    private static List<String> getLines(JTextArea textArea) {
        int lineHeight = getLineHeight(textArea);
        List<String> list = new ArrayList<String>();
        for (int num = 0;; num++) {
            int i = textArea.viewToModel(new Point(0, num * lineHeight));
            int j = textArea.viewToModel(new Point(0, (num + 1) * lineHeight));
            if (i == 0 && j == 0) {
                continue;
            }
            if (textArea.getDocument().getLength() == i && i == j) {
                break;
            }
            String s = removeTrailingNewLine(textArea.getText().substring(i, j));
            list.add(s);
            //System.out.println(i + " " + j + " = " + s);
        }
        return list;
    }

    private static int getLineHeight(JTextArea textArea) {
        return textArea.getFontMetrics(textArea.getFont()).getHeight();
    }

    private static String removeTrailingNewLine(String s) {
        if (s.endsWith("\n")) {
            return s.substring(0, s.length() - 1);
        } else {
            return s;
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TextAreaTest test = new TextAreaTest();
                test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                test.pack();
                test.setVisible(true);
            }
        });
    }
}