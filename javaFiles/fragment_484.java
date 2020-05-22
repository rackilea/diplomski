import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FollowMe {

    public static void main(String[] args) {
        new FollowMe();
    }

    public FollowMe() {
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

        private Point mousePoint;
        private DiamondShape head;

        public TestPane() {
            head = new DiamondShape(10, 20);
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

            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

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

            g2d.rotate(Math.toRadians(rotation), width / 2, height / 2);

            int x = width / 2;
            int y = height / 2;
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.RED);
            g2d.drawLine(x, y, x, y - height / 4);

            y -= height / 4 + (head.getBounds().height);
            x -= head.getBounds().width / 2;
            g2d.fill(head.createTransformedShape(AffineTransform.getTranslateInstance(x, y)));

            g2d.dispose();
            g2d.dispose();
        }

    }

    public class DiamondShape extends Path2D.Double {

        public DiamondShape(int width, int height) {
            moveTo(width / 2, 0);
            lineTo(width, height / 2);
            lineTo(width / 2, height);
            lineTo(0, height / 2);
            closePath();
        }

    }

}