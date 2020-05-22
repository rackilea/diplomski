import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @see https://stackoverflow.com/a/37450393/230513
 */
public class HTree {

    private void display() {
        JFrame f = new JFrame("HTree");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Tree());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class Tree extends JPanel {

        private final Color color = Color.getHSBColor((float) Math.random(), 1, 1);

        public void draw(Graphics g, int n, double sz, double x, double y) {
            if (n == 0) {
                return;
            }
            double x0 = x - sz / 2, x1 = x + sz / 2;
            double y0 = y - sz / 2, y1 = y + sz / 2;
            // draw the 3 line segments of the H 
            g.setColor(color);
            g.drawLine((int) x0, (int) y, (int) x1, (int) y);
            g.drawLine((int) x0, (int) y0, (int) x0, (int) y1);
            g.drawLine((int) x1, (int) y0, (int) x1, (int) y1);
            // recursively draw 4 half-size
            // H-trees of order n-1
            g.setColor(color);
            draw(g, n - 1, sz / 2, x0, y0);
            draw(g, n - 1, sz / 2, x0, y1);
            draw(g, n - 1, sz / 2, x1, y0);
            draw(g, n - 1, sz / 2, x1, y1);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g, 3, getWidth() / 2, getWidth() / 2, getHeight() / 2);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        public static void main(String[] args) {
            EventQueue.invokeLater(new HTree()::display);
        }
    }
}