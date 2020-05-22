import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RotateArrow {

    public static void main(String[] args) {
        new RotateArrow();
    }

    public RotateArrow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new RotatePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class RotatePane extends javax.swing.JPanel {

        private Point mousePoint;
        private PointyThing pointyThing;

        public RotatePane() {

            pointyThing = new PointyThing();

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    mousePoint = e.getPoint();
                    repaint();
                }
            });

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            double rotation = 0f;

            int width = getWidth() - 1;
            int height = getHeight() - 1;

            if (mousePoint != null) {
                int x = width / 2;
                int y = height / 2;

                int deltaX = mousePoint.x - x;
                int deltaY = mousePoint.y - y;

                rotation = -Math.atan2(deltaX, deltaY);
                rotation = Math.toDegrees(rotation) + 180;
            }

            Rectangle bounds = pointyThing.getBounds();

            AffineTransform at = new AffineTransform();
            at.translate((width - bounds.width) / 2, (height - bounds.height) / 2);
            at.rotate(Math.toRadians(rotation), bounds.width / 2, bounds.height / 2);
            Shape shape = new Path2D.Float(pointyThing, at);

            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.RED);

            g2d.fill(shape);
            g2d.draw(shape);
            g2d.dispose();
        }
    }

    public class PointyThing extends Path2D.Float {

        public PointyThing() {
            moveTo(15, 0);
            lineTo(30, 15);
            lineTo(0, 15);
            lineTo(15, 0);
            moveTo(15, 15);
            lineTo(15, 60);
        }

    }
}