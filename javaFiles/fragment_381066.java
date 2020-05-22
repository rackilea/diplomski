import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class board {
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new GridLayout(1, 0));

        JPanel left = new JPanel();
        pane.add(left);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JPanel leftTop = new JPanel();
        leftTop.setPreferredSize(new Dimension(125, 150));
        leftTop.setBackground(Color.black);
        left.add(leftTop);

        JPanel leftBottom = new JPanel();
        leftBottom.setPreferredSize(new Dimension(125, 150));
        leftBottom.setBackground(Color.red);
        left.add(leftBottom);

        JPanel middle = new JPanel();
        pane.add(middle);
        middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));

        JPanel middleTop = new JPanel();
        middleTop.setPreferredSize(new Dimension(125, 100));
        middleTop.setBackground(Color.green);
        middle.add(middleTop);

        JPanel middleBottom = new JPanel();
        middleBottom.setPreferredSize(new Dimension(125, 200));
        middleBottom.setBackground(Color.yellow);
        middle.add(middleBottom);

        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(125, 300));
        right.setBackground(Color.blue);

        pane.add(right);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}