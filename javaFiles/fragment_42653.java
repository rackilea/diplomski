import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Example {

    private Point startPoint = new Point(0, 0);
    private Point rectLocale = new Point();
    private Dimension rectSize = new Dimension();
    private int zoom = 80;
    private BufferedImage capture = null;
    private BufferedImage raw;

    public Example() throws Exception {
        raw = new Robot().createScreenCapture(new Rectangle(
                Toolkit.getDefaultToolkit().getScreenSize()));
        MouseBehavior behavior = new MouseBehavior();
        JPanel b = new JPanel() {

            private static final long serialVersionUID = 1L;

            @Override
            public Dimension getMinimumSize() {
                return new Dimension(500, 500);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 500);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = ((Graphics2D) g);
                g2d.drawImage(raw, 0, 0, null);
                if (capture != null) {
                    int width2 = (int) (rectSize.width + rectSize.width * (zoom / 500d));
                    int height2 = (int) (rectSize.height + rectSize.height * (zoom / 500d));
                    int x2 = rectLocale.x - ((width2 - rectSize.width) / 2);
                    int y2 = rectLocale.y - ((height2 - rectSize.height) / 2);
                    Image scaledInstance = capture.getScaledInstance(
                            width2, height2, Image.SCALE_AREA_AVERAGING);
                    g2d.drawImage(scaledInstance, x2, y2, null);
                    g2d.drawRect(x2, y2, width2, height2);
                } else {
                    g2d.draw(new Rectangle(rectLocale, rectSize));
                }
            }
        };
        b.addMouseMotionListener(behavior);
        b.addMouseListener(behavior);
        b.addMouseWheelListener(behavior);
        JFrame f = new JFrame();
        f.setLocation(10, 10);
        f.setDefaultCloseOperation(3);
        f.add(b);
        f.pack();
        f.setVisible(true);
    }

    private class MouseBehavior extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            startPoint = e.getPoint();
            rectLocale = new Point();
            rectSize = new Dimension();
            capture = null;
            if (e.getSource() instanceof JComponent) {
                ((JComponent) e.getSource()).repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point currentPoint = e.getPoint();
            rectSize.width = Math.abs(currentPoint.x - startPoint.x);
            rectSize.height = Math.abs(currentPoint.y - startPoint.y);
            if (e.isShiftDown()) {
                rectSize.width = rectSize.height = Math.min(
                        rectSize.width, rectSize.height);
                int dx = startPoint.x - rectSize.width;
                int dy = startPoint.y - rectSize.height;
                rectLocale.x = startPoint.x < currentPoint.x ? startPoint.x
                        : Math.max(dx, dy);
                rectLocale.y = startPoint.y < currentPoint.y ? startPoint.y
                        : Math.min(dx, dy);
            } else {
                rectLocale.x = Math.min(currentPoint.x, startPoint.x);
                rectLocale.y = Math.min(currentPoint.y, startPoint.y);
            }
            if (e.getSource() instanceof JComponent) {
                ((JComponent) e.getSource()).repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (rectSize.width <= 0 || rectSize.height <= 0) {
                capture = null;
            } else {
                capture = raw.getSubimage(Math.max(0, rectLocale.x),
                        Math.max(0, rectLocale.y), rectSize.width, rectSize.height);
            }
            if (e.getSource() instanceof JComponent) {
                ((JComponent) e.getSource()).repaint();
            }
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            zoom = Math.min(2000, Math.max(0, zoom + e.getUnitsToScroll() * 10));
            if (e.getSource() instanceof JComponent) {
                ((JComponent) e.getSource()).repaint();
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Example example = new Example();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}