import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Reminder {
    private static final String TEXT = "Test hiiii what happpn";
    private static final String[] WORDS = TEXT.split(" ");
    private JFrame frame;
    private Timer timer;
    private StyledDocument doc;
    private JTextPane textpane;
    private List<Integer> times = Arrays.asList(1000, 900, 300, 1500);

    private int stringIndex = 0;
    private int index = 0;

    public void startColoring() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                doc.setCharacterAttributes(stringIndex, 1, textpane.getStyle("Red"), true);
                stringIndex++;
                try {
                    if (stringIndex >= doc.getLength() || doc.getText(stringIndex, 1).equals(" ")) {
                        index++;
                    }
                    if (index < times.size()) {
                        double delay = times.get(index).doubleValue();
                        timer.setDelay((int) (delay / WORDS[index].length()));
                    } else {
                        timer.stop();
                        System.err.println("Timer stopped");
                    }
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        };
        timer = new Timer(times.get(index), actionListener);
        timer.setInitialDelay(0);
        timer.start();
    }

    public void initUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        doc = new DefaultStyledDocument();
        textpane = new JTextPane(doc);
        textpane.setText(TEXT);
        javax.swing.text.Style style = textpane.addStyle("Red", null);
        StyleConstants.setForeground(style, Color.RED);
        panel.add(textpane);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                Reminder reminder = new Reminder();
                reminder.initUI();
                reminder.startColoring();
            }
        });
    }
}