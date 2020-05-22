import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class TimerDemo {

    private JTextField field;
    private JLabel statusLabel;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                new TimerDemo();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public TimerDemo() {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(0, 1));

        field = new JTextField(20);
        field.getDocument().addDocumentListener(new TimerDocumentListener());
        statusLabel = new JLabel(" ");

        JButton start = new JButton("Start Fake Typing");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startInsertTimer();
            }
        });

        frame.add(field);
        frame.add(statusLabel);
        frame.add(start);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void startInsertTimer() {
        Timer timer = new Timer(500, new ActionListener() {
            private int count = 9;

            public void actionPerformed(ActionEvent e) {
                if (count == 0) {
                    ((Timer) e.getSource()).stop();
                } else {
                    Document doc = field.getDocument();
                    int length = doc.getLength();
                    try {
                        doc.insertString(length, Integer.toString(count), null);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(TimerDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    count--;
                }
            }
        });
        timer.start();
    }

    class TimerDocumentListener implements DocumentListener {

        private Document doc;
        private Timer timer;

        public TimerDocumentListener() {
            timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (doc != null) {
                        try {
                            String text = doc.getText(0, doc.getLength());
                            statusLabel.setText(text);
                        } catch (BadLocationException ex) {
                            Logger.getLogger(TimerDemo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            timer.setRepeats(false);
        }

        public void insertUpdate(DocumentEvent e) { set(e); }
        public void removeUpdate(DocumentEvent e) { set(e); }
        public void changedUpdate(DocumentEvent e) { set(e); }

        private void set(DocumentEvent e) {
            if (timer.isRunning()) {
                timer.restart();
            } else {
                this.doc = e.getDocument();
                timer.start();
            }
        }
    }
}