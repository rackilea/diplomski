import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        mainPanel.add(new Player());
        mainPanel.add(new Ball());
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

class Player extends JPanel {

    public Player() {
        setBorder(BorderFactory.createLineBorder(Color.RED, 2, false));
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.BLACK);

        new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(20, 100, 20, 100);
    }
}

class Ball extends JPanel {

    public Ball() {
        setBorder(BorderFactory.createLineBorder(Color.CYAN, 2, false));
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.BLACK);
        new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(300, 300, 10, 10);
    }
}