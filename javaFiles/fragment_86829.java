import javax.swing.*;
import java.awt.*;

/** @see http://stackoverflow.com/questions/6536178 */
public class JTextAreaPasteTest {

    public static void main(String argv[]) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                display();
            }
        });
    }

    private static void display() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String testStr = "Paste text here.";
        JTextArea wrapArea = new JTextArea(testStr, 20, 40);
        wrapArea.setLineWrap(true);
        wrapArea.setWrapStyleWord(true);
        wrapArea.setCaretPosition(testStr.length());
        frame.add(new JScrollPane(wrapArea));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}