import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame extends JFrame {

    public static void main(String... s){
        new TestFrame();
    }

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        add(new DrawPanel());
    }

    private class DrawPanel extends JPanel {

        public static final int WIDTH = 15;
        public static final int HEIGHT = 15;
        private static final int BLOCK_SIZE = 30;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Color c = g.getColor();
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, HEIGHT * BLOCK_SIZE, WIDTH * BLOCK_SIZE);
            g.setColor(c);
            g.fillOval(0, 0, 100, 100);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(HEIGHT * BLOCK_SIZE, WIDTH * BLOCK_SIZE);
        }
    }
}