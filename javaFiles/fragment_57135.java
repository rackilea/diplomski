import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        protected static final int[][] MAP
                = {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1}
                };
        protected static Dimension GRID_SIZE = new Dimension(20, 20);
        private Rectangle buf; // This represents your image

        private Dimension preferredSize;
        public TestPane() {
            buf = new Rectangle(0, 0, GRID_SIZE.width, GRID_SIZE.height);

            int max = 0;
            for (int row = 0; row < MAP.length; row++) {
                max = Math.max(max, MAP[row].length);
            }
            preferredSize = new Dimension(GRID_SIZE.width * MAP.length, GRID_SIZE.height * max);
        }

        @Override
        public Dimension getPreferredSize() {
            return preferredSize;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (int row = 0; row < MAP.length; row++) {
                for (int col = 0; col < MAP[row].length; col++) {
                    int x = GRID_SIZE.width * row;
                    int y = GRID_SIZE.height * col;
                    Graphics2D translated = (Graphics2D) g2d.create();
                    translated.translate(x, y);
                    translated.draw(buf);
                    translated.dispose();
                }
            }
            g2d.dispose();
        }

    }
}