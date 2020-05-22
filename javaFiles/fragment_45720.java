import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Example {

    private JTextPane log;
    private int counter;

    public Example() {
        log = new JTextPane();
        log.setEditable(false);

        JTextField field = new JTextField(15);
        field.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                appendMessage(evt.getPropertyName(), Color.GRAY);
            }
        });
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                appendMessage("Changed", Color.BLACK);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                appendMessage("Inserted", Color.BLACK);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                appendMessage("Removed", Color.BLACK);
            }
        });
        field.setText("Test");

        JFrame frame = new JFrame();
        frame.add(field, BorderLayout.NORTH);
        frame.add(new JScrollPane(log));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void appendMessage(String message, Color color) {
        StyledDocument doc = log.getStyledDocument();
        Style style = log.addStyle("style1", null);
        StyleConstants.setForeground(style, color);
        try {
            doc.insertString(doc.getLength(), ++counter + ". " + message + "\n", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

}