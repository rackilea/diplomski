import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Blah extends JPanel {
    public Blah() {
        final JButton X = new JButton("X");
        final JLabel Y = new JLabel("yyyyyyyyyyy");
        Y.setOpaque(true);
        Y.setBackground(Color.YELLOW);
        final JProgressBar Z = new JProgressBar();
        Z.setIndeterminate(true);

        final SpringLayout l = new SpringLayout();
        super.setLayout(l);

        super.add(X);
        super.add(Y);
        super.add(Z);

        Z.setMaximumSize(Z.getPreferredSize());

        l.putConstraint(SpringLayout.WEST, X, 10, SpringLayout.WEST, this);
        l.putConstraint(SpringLayout.WEST, Y, 10, SpringLayout.EAST, X);
        l.putConstraint(SpringLayout.WEST, Z, 10, SpringLayout.EAST, Y);
        l.putConstraint(SpringLayout.EAST, this, 10, SpringLayout.EAST, Z);

        l.putConstraint(SpringLayout.NORTH, X, 10, SpringLayout.NORTH, this);
        l.putConstraint(SpringLayout.NORTH, Y, 10, SpringLayout.NORTH, this);
        l.putConstraint(SpringLayout.NORTH, Z, 10, SpringLayout.NORTH, this);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame frame = new JFrame("Blah");
                frame.add(new Blah());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}