import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ZoomBoxWindow {

    public static void main(String[] args) {
        new ZoomBoxWindow();
    }

    public ZoomBoxWindow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                TestPane pane = new TestPane();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(pane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage img;
        private Point zoomPoint;
        private boolean zoomEnabled = true;
        private int zoomArea = 80;
        private float zoom = 2.0f;

        public TestPane() {
            try {
                img = ImageIO.read(new File("/Volumes/Big Fat Extension/Dropbox/MegaTokyo/_cg_1009___Afraid___by_Serena_Clearwater.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    zoomPoint = e.getPoint();
                    repaint();
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    zoomPoint = null;
                    repaint();
                }

            });
        }

        public float getZoom() {
            return zoom;
        }

        public void setZoom(float zoom) {
            this.zoom = zoom;
            repaint();
        }

        public int getZoomArea() {
            return zoomArea;
        }

        public void setZoomArea(int zoomArea) {
            this.zoomArea = zoomArea;
            repaint();
        }

        public boolean isZoomEnabled() {
            return zoomEnabled;
        }

        public void setZoomEnabled(boolean zoomEnabled) {
            this.zoomEnabled = zoomEnabled;
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }

        protected Point getOffset() {
            if (img == null) {
                return new Point(0, 0);
            }
            int x = (getWidth() - img.getWidth()) / 2;
            int y = (getHeight() - img.getHeight()) / 2;
            return new Point(x, y);
        }

        protected Rectangle getImageBounds() {
            Rectangle bounds = new Rectangle(0, 0, 0, 0);
            if (img != null) {
                bounds.setLocation(getOffset());
                bounds.setSize(img.getWidth(), img.getHeight());
            }
            return bounds;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                Point offset = getOffset();
                g2d.drawImage(img, offset.x, offset.y, this);
                if (zoomPoint != null) {
                    BufferedImage zoomBuffer = updateBuffer(zoomPoint);
                    if (zoomBuffer != null) {
                        Rectangle bounds = getZoomBounds();
                        g2d.drawImage(zoomBuffer, bounds.x, bounds.y, this);
                        g2d.setColor(Color.RED);
                        g2d.draw(bounds);
                    }
                }
                g2d.dispose();
            }
        }

        protected Rectangle getZoomBounds() {
            Rectangle bounds = null;
            if (zoomPoint != null && img != null) {
                int zoomArea = getZoomArea();
                int xPos = zoomPoint.x - (zoomArea / 2);
                int yPos = zoomPoint.y - (zoomArea / 2);

                Rectangle zoomBounds = new Rectangle(xPos, yPos, zoomArea, zoomArea);
                Rectangle imageBounds = getImageBounds();

                bounds = imageBounds.intersection(zoomBounds);
                System.out.println(bounds);
            }
            return bounds;
        }

        protected BufferedImage updateBuffer(Point p) {
            if (zoomPoint == null) {
                return null;
            }
            Rectangle bounds = getZoomBounds();
            Point offset = getOffset();
            bounds.translate(-offset.x, -offset.y);
            if (bounds.x < 0 || bounds.y < 0 || bounds.width <= 0 || bounds.height <= 0) {
                return null;
            }
            BufferedImage zoomBuffer = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = zoomBuffer.createGraphics();

            BufferedImage sample = img.getSubimage(bounds.x, bounds.y, bounds.width, bounds.height);
            double zoom = getZoom();
            Image scaled = sample.getScaledInstance((int) (bounds.width * zoom), (int) (bounds.height * zoom), Image.SCALE_SMOOTH);

            g2d.drawImage(scaled, 0, 0, this);
            g2d.dispose();
            return zoomBuffer;
        }

    }

}