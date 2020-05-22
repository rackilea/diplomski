import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RotateShape {

    public static void main(String[] args) {
        new RotateShape();
    }

    public RotateShape() {
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

        private Star star;
        private double rotationDelta = 5d;
        private int xDelta = 0;
        private int yDelta = 0;

        public TestPane() {
            star = new Star(50, 50);
            star.moveLocatioBy(75, 75);

            Random rnd = new Random();
            xDelta = rnd.nextInt(4) + 1;
            yDelta = rnd.nextInt(4) + 1;

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    star.moveLocatioBy(xDelta, yDelta);
                    Rectangle bounds = star.getBounds();
                    int x = star.getX();
                    int y = star.getY();

                    boolean bounced = false;
                    if (x < 0) {
                        x = 0;
                        xDelta *= -1;
                        bounced = true;
                    } else if (x + bounds.width > getWidth()) {
                        x = getWidth() - bounds.width;
                        xDelta *= -1;
                        bounced = true;
                    }
                    if (y < 0) {
                        y = 0;
                        yDelta *= -1;
                        bounced = true;
                    } else if (y + bounds.height > getHeight()) {
                        y = getHeight() - bounds.height;
                        yDelta *= -1;
                        bounced = true;
                    }
                    if (bounced) {
                        rotationDelta *= -1;
                    }

                    star.rotateByDegrees(rotationDelta);
                    star.setLocation(x, y);
                    repaint();
                }
            });
            timer.start();

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

            Shape shape = star.getTransformedInstance();
            g2d.setColor(Color.BLUE);
            g2d.fill(shape);
            g2d.setColor(Color.RED);
            g2d.draw(shape);
            g2d.dispose();
        }

    }

    public class Star extends Path2D.Double {

        private double angle = 0;
        private int x = 0, y = 0;

        public Star(int width, int height) {

            double heightPart = height / 3d;
            double widthPart = width / 3d;

            moveTo(width / 2, 0);
            lineTo(widthPart * 2, heightPart);
            lineTo(width, heightPart);
            lineTo(widthPart * 2, height / 2);
            lineTo(width, height);

            lineTo(width / 2, heightPart * 2);
            lineTo(0, height);
            lineTo(widthPart, height / 2);
            lineTo(0, heightPart);
            lineTo(widthPart, heightPart);

            closePath();
        }

        public double getAngle() {
            return angle;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void moveLocatioBy(int xDelta, int yDelta) {
            this.x += xDelta;
            this.y += yDelta;
        }

        public void rotateByDegrees(double delta) {
            angle += delta;
        }

        public void setLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Shape getTransformedInstance() {
            AffineTransform at = new AffineTransform();
            Rectangle bounds = getBounds();
            at.rotate(Math.toRadians(angle), x + (bounds.width / 2), y + (bounds.height / 2));
            at.translate(x, y);
            return createTransformedShape(at);
        }

    }

}