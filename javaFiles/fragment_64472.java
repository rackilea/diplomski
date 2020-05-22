import java.awt.Dimension;
import javax.swing.*;
public class Test extends JPanel {
    private JTextArea txt1 = new JTextArea();
    private JTextArea txt2 = new JTextArea() {
        public void addNotify() {
            super.addNotify();
            requestFocus();
        }
    };

    public Test() {
        setLayout(null);
        setPreferredSize(new Dimension(200, 100));
        txt1.setBounds(20, 20, 220, 20);
        txt2.setBounds(20, 45, 220, 20);
        txt1.setText("Text Field #1");
        txt2.setText("Text Field #2");
        add(txt1);
        add(txt2);
    }

    private void display() {
        Object[] options = { this };
        JOptionPane pane = new JOptionPane();
        pane.showOptionDialog(null, null, "Title", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, txt2);
    }

    public static void main(String[] args) {
        new Test().display();
    }
}