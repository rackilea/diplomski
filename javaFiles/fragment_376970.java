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
import java.awt.geom.Line2D;
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

        private PointyThing pointyThing;
        private Point mouseStart;
        private Point mouseEnd;

        public RotatePane() {

            pointyThing = new PointyThing();

            MouseAdapter ma = new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    mouseEnd = e.getPoint();
                    repaint();
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    mouseStart = e.getPoint();
                    repaint();
                }
            };

            addMouseListener(ma);
            addMouseMotionListener(ma);

        }

        @Override
        public Dimension getPreferredSize() {

            return new Dimension(200, 200);

        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();
            if (mouseStart != null && mouseEnd != null) {

                double rotation = 0f;

                int width = getWidth() - 1;
                int height = getHeight() - 1;

                if (mouseEnd != null) {

                    int x = mouseStart.x;
                    int y = mouseStart.y;

                    int deltaX = mouseEnd.x - x;
                    int deltaY = mouseEnd.y - y;

                    rotation = -Math.atan2(deltaX, deltaY);
                    rotation = Math.toDegrees(rotation) + 180;

                }

                Rectangle bounds = pointyThing.getBounds();

                g2d.setStroke(new BasicStroke(3));
                g2d.setColor(Color.RED);
                g2d.draw(new Line2D.Float(mouseStart, mouseEnd));

                AffineTransform at = new AffineTransform();

                at.translate(mouseEnd.x - (bounds.width / 2), mouseEnd.y - (bounds.height / 2));
                at.rotate(Math.toRadians(rotation), bounds.width / 2, bounds.height / 2);
                Shape shape = new Path2D.Float(pointyThing, at);

                g2d.fill(shape);
                g2d.draw(shape);
            }
            g2d.dispose();

        }

    }

    public class PointyThing extends Path2D.Float {

        public PointyThing() {
            moveTo(15, 0);
            lineTo(30, 15);
            lineTo(0, 15);
            lineTo(15, 0);
        }

    }

}