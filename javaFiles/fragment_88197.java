import javax.swing.*;
import java.awt.*;

public class Spielplan {

public static void main(String[] args) {

    JFrame f1 = new JFrame();
    f1.setLayout(new BorderLayout());
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.setPreferredSize(new Dimension(960, 800));

    JButton tokens = new JButton("Spielsteine setzen");
    f1.add(tokens, BorderLayout.NORTH);

    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(3,3));
    f1.add(p1, BorderLayout.CENTER);

    JPanel g1 = new JPanel();
    g1.setBorder(BorderFactory.createLineBorder(Color.RED));
    g1.setPreferredSize(new Dimension(100, 100));
    g1.setVisible(true);
    p1.add(g1);

    JPanel g2 = new JPanel();
    g2.setBorder(BorderFactory.createLineBorder(Color.RED));
    g2.setPreferredSize(new Dimension(100, 100));
    g2.setVisible(true);
    p1.add(g2);

    JPanel g3 = new JPanel();
    g3.setBorder(BorderFactory.createLineBorder(Color.RED));
    g3.setPreferredSize(new Dimension(100, 100));
    g3.setVisible(true);
    p1.add(g3);

    JPanel g4 = new JPanel();
    g4.setBorder(BorderFactory.createLineBorder(Color.RED));
    g4.setPreferredSize(new Dimension(100, 100));
    g4.setVisible(true);
    p1.add(g4);

    JPanel g5 = new JPanel();
    g5.setBorder(BorderFactory.createLineBorder(Color.RED));
    g5.setPreferredSize(new Dimension(100, 100));
    g5.setVisible(true);
    p1.add(g5);

    JPanel g6 = new JPanel();
    g6.setBorder(BorderFactory.createLineBorder(Color.RED));
    g6.setPreferredSize(new Dimension(100, 100));
    g6.setVisible(true);
    p1.add(g6);

    JPanel g7 = new JPanel();
    g7.setBorder(BorderFactory.createLineBorder(Color.RED));
    g7.setPreferredSize(new Dimension(100, 100));
    g7.setVisible(true);
    p1.add(g7);

    JPanel g8 = new JPanel();
    g8.setBorder(BorderFactory.createLineBorder(Color.RED));
    g8.setPreferredSize(new Dimension(100, 100));
    g8.setVisible(true);
    p1.add(g8);

    JPanel g9 = new JPanel();
    g9.setBorder(BorderFactory.createLineBorder(Color.RED));
    g9.setPreferredSize(new Dimension(100, 100));
    g9.setVisible(true);
    p1.add(g9);

    f1.pack();
    f1.setVisible(true);
}