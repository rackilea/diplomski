import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class NumPad extends JPanel {
    public NumPad() {
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new GridLayout(1, 0));
        top.add(new JButton("Num"));
        top.add(new JButton("/"));
        top.add(new JButton("*"));
        top.add(new JButton("-"));
        add(top, BorderLayout.NORTH);
        JPanel p2p4 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new GridLayout(3, 0));
        p2.add(new JButton("7"));
        p2.add(new JButton("8"));
        p2.add(new JButton("9"));
        p2.add(new JButton("4"));
        p2.add(new JButton("5"));
        p2.add(new JButton("6"));
        p2.add(new JButton("1"));
        p2.add(new JButton("2"));
        p2.add(new JButton("3"));
        p2p4.add(p2, BorderLayout.CENTER);

        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(1, 0, 30, 40));
        p4.add(new JButton("0"));
        p4.add(new JButton("."));
        p2p4.add(p4, BorderLayout.SOUTH);
        add(p2p4);
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(2, 0));
        p3.add(new JButton("+"));
        p3.add(new JButton("Enter"));
        add(p3, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame(NumPad.class.getSimpleName());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                NumPad numPad = new NumPad();
                frame.add(numPad);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}