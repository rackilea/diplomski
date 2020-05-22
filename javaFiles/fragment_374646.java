import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

        private Point from;
        private Point clickTo;
        private Point to;

        public TestPane() {
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    from = new Point(getWidth() / 2, getHeight() / 2);
                    to = e.getPoint();
                    clickTo = new Point(to);
                    double angle = Math.atan2(to.y - from.y, to.x - from.x);
                    int radius = Math.max(getWidth(), getHeight()) * 2;

                    to.x = (int) (Math.round(from.x + (radius * Math.cos(angle))));
                    to.y = (int) (Math.round(from.y + (radius * Math.sin(angle))));
                    repaint();
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public Point2D getIntersectionPoint(Line2D line1, Line2D line2) {
            if (!line1.intersectsLine(line2)) {
                return null;
            }
            double px = line1.getX1(),
                    py = line1.getY1(),
                    rx = line1.getX2() - px,
                    ry = line1.getY2() - py;
            double qx = line2.getX1(),
                    qy = line2.getY1(),
                    sx = line2.getX2() - qx,
                    sy = line2.getY2() - qy;

            double det = sx * ry - sy * rx;
            if (det == 0) {
                return null;
            } else {
                double z = (sx * (qy - py) + sy * (px - qx)) / det;
                if (z == 0 || z == 1) {
                    return null;  // intersection at end point!
                }
                return new Point2D.Float(
                        (float) (px + z * rx), (float) (py + z * ry));
            }
        } // end intersection line-line

        public Point2D getIntersectionPoint(Line2D line, Rectangle bounds) {
            Point2D top = getIntersectionPoint(line, new Line2D.Double(bounds.x, bounds.y, bounds.x + bounds.width, bounds.y));
            Point2D bottom = getIntersectionPoint(line, new Line2D.Double(bounds.x, bounds.y + bounds.height, bounds.x + bounds.width, bounds.y + bounds.height));
            Point2D left = getIntersectionPoint(line, new Line2D.Double(bounds.x, bounds.y, bounds.x, bounds.y + bounds.height));
            Point2D right = getIntersectionPoint(line, new Line2D.Double(bounds.x + bounds.width, bounds.y, bounds.x + bounds.width, bounds.y + bounds.height));

            return top != null ? top 
                    : bottom != null ? bottom 
                    : left != null ? left
                    : right != null ? right
                    : null;
        } 

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();
            Rectangle bounds = new Rectangle(50, 50, getWidth() - 100, getHeight() - 100);
            g2d.draw(bounds);

            if (from != null) {
                g2d.setColor(Color.RED);
                g2d.fillOval(from.x - 4, from.y - 4, 8, 8);

                if (to != null) {
                    g2d.setColor(Color.GREEN);
                    g2d.fillOval(clickTo.x - 4, clickTo.y - 4, 8, 8);

                    Line2D line = new Line2D.Double(from, to);
                    g2d.setColor(Color.BLUE);
                    g2d.draw(line);

                    Point2D intersectPoint = getIntersectionPoint(line, bounds);

                    g2d.setColor(Color.MAGENTA);
                    g2d.fill(new Ellipse2D.Double(intersectPoint.getX() - 4, intersectPoint.getY() - 4, 8, 8));

                    g2d.draw(new Line2D.Double(from, intersectPoint));
                }
            }
            g2d.dispose();
        }

    }

}