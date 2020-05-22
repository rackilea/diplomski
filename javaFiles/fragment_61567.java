import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class GUI {

    JFrame f1 = new JFrame("GUI");
    JLabel l1 = new JLabel("Output");
    JTextField tf1 = new JTextField("");

    public void run(){  // main calls this method.
        f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        f1.setBounds(450, 170, 400, 400);
        f1.setVisible(true);
        f1.setResizable(false);
        f1.setLayout(new GridLayout(2,1));

        f1.add(l1);
        f1.add(tf1);

        f1.pack();

        Listener listener = new Listener(this);
        listener.listen(tf1);
    }

    public static void main(String[] args) {
        new GUI().run();
    }

    public boolean everythingOK() {
        return tf1.getText().length() > 0;
    }

    class Listener {
        private GUI gui;

        public Listener(GUI gui) {
            this.gui = gui;
        }

        public void listen(final JTextField textfield) {

            textfield.getDocument().addDocumentListener(new DocumentListener() {

                public void changedUpdate(DocumentEvent e) { test(); }
                public void removeUpdate(DocumentEvent e) { test(); }
                public void insertUpdate(DocumentEvent e) { test(); }

                public void test() {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            if (gui.everythingOK()) { // everythingOK is just a boolean that test if input is valid number and returns true if it is.
                                gui.l1.setText("No errors."); // this code is supposed to change JLabels text.
                            } else {
                                gui.l1.setText("Error."); // this code is supposed to change JLabels text.
                            }
                        }
                    });
                }
            });
        }
    }
}