import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

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

        private ImageLabel label;

        public TestPane() {
            setLayout(new GridBagLayout());
            label = new ImageLabel();
            add(label);

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    label.pointImageToPoint(e.getPoint(), TestPane.this);
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public final class ImageLabel extends JLabel {

        private double angle = 0;
        private Point imageLocation = new Point();
        private File imageFile = null;
        private Dimension imageSize = new Dimension(50, 50);
        private BufferedImage bi;

        public ImageLabel() {
            setBorder(new LineBorder(Color.BLUE));
            bi = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.setColor(Color.RED);
            g2d.drawLine(25, 0, 25, 50);
            g2d.drawLine(25, 0, 0, 12);
            g2d.drawLine(25, 0, 50, 12);
            g2d.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(bi.getWidth(), bi.getHeight());
        }

        protected Point centerPoint() {
            return new Point(getWidth() / 2, getHeight() / 2);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bi == null) {
                return;
            }
            Graphics2D g2d = (Graphics2D) g.create();
            AffineTransform at = g2d.getTransform();
            Point center = centerPoint();
            at.translate(center.x, center.y);
            at.rotate(angle, 0, 0);
            g2d.setTransform(at);
            g2d.drawImage(bi, -bi.getWidth() / 2, -bi.getHeight() / 2, this);
            g2d.dispose();
        }

        public void rotateImage(float angle) { // rotate the image to specific angle
            this.angle = (float) Math.toRadians(angle);
            repaint();
        }

        public void pointImageToPoint(Point target, JComponent fromContext) {
            calculateAngle(target, fromContext);
            repaint();
        }

        private void calculateAngle(Point target, JComponent fromContext) {
            // calculate the angle from the center of the image
            target = SwingUtilities.convertPoint(fromContext, target, this);
            Point center = centerPoint();
            float deltaY = target.y - center.y;
            float deltaX = target.x - center.x;
            angle = (float) -Math.atan2(deltaX, deltaY);
            angle = Math.toRadians(Math.toDegrees(angle) + 180.0);
            repaint();
        }
    }
}