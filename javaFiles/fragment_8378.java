import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RedSunGame {

    private static final int SQUARE_SIZE = 20;
    private JPanel rs;
    private JFrame frame;

    private void initUI() {
        frame = new JFrame("Red Sun");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rs = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.YELLOW);
                g.fillRect(0, 0, SQUARE_SIZE, SQUARE_SIZE);
            }

            @Override
            public Dimension getPreferredSize() {
                Dimension preferredSize = super.getPreferredSize();
                // Let's make sure that we have at least our little square size.
                preferredSize.width = Math.max(preferredSize.width, SQUARE_SIZE);
                preferredSize.height = Math.max(preferredSize.height, SQUARE_SIZE);
                return preferredSize;
            }
        };
        frame.add(rs);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RedSunGame redSunGame = new RedSunGame();
                redSunGame.initUI();
            }
        });
    }
}