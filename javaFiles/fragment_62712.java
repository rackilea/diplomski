import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Srap {

    public static void main(String[] args) {
        JTextPane textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();

        Style style = textPane.addStyle("I'm a Style", null);
        StyleConstants.setForeground(style, Color.red);

        try {
            doc.insertString(doc.getLength(), "BLAH ", style);
        } catch (BadLocationException ex) {
        }

        StyleConstants.setForeground(style, Color.blue);

        try {
            doc.insertString(doc.getLength(), "BLEH", style);
        } catch (BadLocationException e) {
        }

        Color color = null;
        int startIndex = 0;
        do {
            Element element = doc.getCharacterElement(startIndex);
            color = doc.getForeground(element.getAttributes());
            startIndex++;
        } while (!color.equals(Color.RED));
        startIndex--;

        if (startIndex >= 0) {

            int endIndex = startIndex;
            do {
                Element element = doc.getCharacterElement(endIndex);
                color = doc.getForeground(element.getAttributes());
                endIndex++;
            } while (color.equals(Color.RED));
            endIndex--;
            if (endIndex > startIndex) {
                try {
                    String text = doc.getText(startIndex, endIndex);
                    System.out.println("Red text = " + text);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Not Found");
            }
        } else {
            System.out.println("Not Found");
        }
    }
}