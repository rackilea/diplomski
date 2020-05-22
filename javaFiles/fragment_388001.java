import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Pointy {

    public static void main(String[] args) {
        new Pointy();
    }

    public Pointy() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Point[] points = new Point[10];

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Point[] coordinates = pointArray();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.WHITE);

            for (int i = 0; i < coordinates.length; i++) {
                int x = coordinates[i].x;
                int y = coordinates[i].y;
                g.fillOval(x, y, 5, 5);
            }
        }

        public Point[] pointArray() {

            points[0] = new Point(100, 100);
            Random randGen = new Random();

            for (int i = 1; i < points.length; i++) {
                int randX = (randGen.nextInt(5) - 2);
                int randY = (randGen.nextInt(5) - 2);
                points[i] = new Point(100 + randX, 100 + randY);
            }
            return points;
        }

    }

}