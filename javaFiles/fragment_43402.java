import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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

        private Ellipse2D circle1;
        private Ellipse2D circle2;

        private Point2D drawTo;

        public TestPane() {
            circle1 = new Ellipse2D.Double(10, 10, 40, 40);
            circle2 = new Ellipse2D.Double(100, 150, 40, 40);

            //addMouseMotionListener(new MouseAdapter() {
            //  @Override
            //  public void mouseMoved(MouseEvent e) {
            //      drawTo = new Point2D.Double(e.getPoint().x, e.getPoint().y);
            //      repaint();
            //  }
            //});
        }

        protected Point2D center(Rectangle2D bounds) {
            return new Point2D.Double(bounds.getCenterX(), bounds.getCenterY());
        }

        protected double angleBetween(Shape from, Shape to) {
            return angleBetween(center(from.getBounds2D()), center(to.getBounds2D()));
        }

        protected double angleBetween(Point2D from, Point2D to) {
            double x = from.getX();
            double y = from.getY();

            // This is the difference between the anchor point
            // and the mouse.  Its important that this is done
            // within the local coordinate space of the component,
            // this means either the MouseMotionListener needs to
            // be registered to the component itself (preferably)
            // or the mouse coordinates need to be converted into
            // local coordinate space
            double deltaX = to.getX() - x;
            double deltaY = to.getY() - y;

            // Calculate the angle...
            // This is our "0" or start angle..
            double rotation = -Math.atan2(deltaX, deltaY);
            rotation = Math.toRadians(Math.toDegrees(rotation) + 180);

            return rotation;
        }

        protected Point2D getPointOnCircle(Shape shape, double radians) {
            Rectangle2D bounds = shape.getBounds();
//          Point2D point = new Point2D.Double(bounds.getX(), bounds.getY());
            Point2D point = center(bounds);
            return getPointOnCircle(point, radians, Math.max(bounds.getWidth(), bounds.getHeight()) / 2d);
        }

        protected Point2D getPointOnCircle(Point2D center, double radians, double radius) {

            double x = center.getX();
            double y = center.getY();

            radians = radians - Math.toRadians(90.0); // 0 becomes th?e top
            // Calculate the outter point of the line
            double xPosy = Math.round((float) (x + Math.cos(radians) * radius));
            double yPosy = Math.round((float) (y + Math.sin(radians) * radius));

            return new Point2D.Double(xPosy, yPosy);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.draw(circle1);
            g2d.draw(circle2);

            // This was used for testing, it will draw a line from circle1 to the
            // drawTo point, which, if enabled, is the last known position of the
            // mouse
            //if (drawTo != null) {
            //  Point2D pointFrom = center(circle1.getBounds2D());
            //  g2d.setColor(Color.RED);
            //  g2d.draw(new Line2D.Double(drawTo, pointFrom));
            //
            //  double from = angleBetween(pointFrom, drawTo);
            //  System.out.println(NumberFormat.getNumberInstance().format(Math.toDegrees(from)));
            //
            //  Point2D poc = getPointOnCircle(circle1, from);
            //  g2d.setColor(Color.BLUE);
            //  g2d.draw(new Line2D.Double(poc, drawTo));
            //}

            double from = angleBetween(circle1, circle2);
            double to = angleBetween(circle2, circle1);

            Point2D pointFrom = getPointOnCircle(circle1, from);
            Point2D pointTo = getPointOnCircle(circle2, to);

            g2d.setColor(Color.RED);
            Line2D line = new Line2D.Double(pointFrom, pointTo);
            g2d.draw(line);
            g2d.dispose();
        }

    }

}