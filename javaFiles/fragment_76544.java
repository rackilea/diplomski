import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelephonePanel extends JPanel {

String numberString = "";

JTextField jtf = new JTextField();
JButton b1 = new JButton("1");
JButton b2 = new JButton("2");
JButton b3 = new JButton("3");
JButton b4 = new JButton("4");
JButton b5 = new JButton("5");
JButton b6 = new JButton("6");
JButton b7 = new JButton("7");
JButton b8 = new JButton("8");
JButton b9 = new JButton("9");
JButton ba = new JButton("*");
JButton b0 = new JButton("0");
JButton bp = new JButton("#");
JButton bclear = new JButton("Clear");

public TelephonePanel() {

    JPanel panel1 = new JPanel(new GridLayout(4, 3));

    panel1.add(b1);
    panel1.add(b2);
    panel1.add(b3);
    panel1.add(b4);
    panel1.add(b5);
    panel1.add(b6);
    panel1.add(b7);
    panel1.add(b8);
    panel1.add(b9);
    panel1.add(ba);
    panel1.add(b0);
    panel1.add(bp);

    ButtonListener listener = new ButtonListener();

    b1.addActionListener(listener);

    // add listener to all buttons

    setLayout(new BorderLayout());
    add(panel1, BorderLayout.CENTER);
    add(bclear, BorderLayout.SOUTH);
    add(jtf, BorderLayout.NORTH);

    jtf.setHorizontalAlignment(SwingConstants.RIGHT);
    jtf.setPreferredSize(new Dimension(300, 30));

}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            JFrame frame = new JFrame();
            frame.add(new TelephonePanel());
            frame.setSize(300, 400);
            frame.setVisible(true);

        }
    });
}

class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            numberString += "1";
            jtf.setText(numberString);
        } else if (e.getSource() == b2) {
            numberString += "2";
            jtf.setText(numberString);
        }

        // finish all the else ifs
    }

}
}