import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Zoom-able scroll panel
 */
public class ZoomScrollPanel {

    // the size of our image
    private final static int IMAGE_SIZE = 600;

    // create an image to display
    private BufferedImage getImage() {
        BufferedImage image = new BufferedImage(IMAGE_SIZE, IMAGE_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        // draw the small pixel first
        Random rand = new Random();
        for (int x = 0; x < IMAGE_SIZE; x += 10) {
            for (int y = 0; y < IMAGE_SIZE; y += 10) {
                g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
                g.fillRect(x, y, 10, 10);
            }
        }
        // draw the larger transparent pixel second
        for (int x = 0; x < IMAGE_SIZE; x += 100) {
            for (int y = 0; y < IMAGE_SIZE; y += 100) {
                g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255), 180));
                g.fillRect(x, y, 100, 100);
            }
        }
        return image;
    }

    // the image panel that resizes according to zoom level
    private class ImagePanel extends JPanel {
        private final BufferedImage image = getImage();

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g.create();
            g2.scale(scale, scale);
            g2.drawImage(image, 0, 0, null);
            g2.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension((int)Math.round(IMAGE_SIZE * scale), (int)Math.round(IMAGE_SIZE * scale));
        }
    }

    // the current zoom level (100 means the image is shown in original size)
    private double zoom = 100;
    // the current scale (scale = zoom/100)
    private double scale = 1;

    // the last seen scale
    private double lastScale = 1;

    // true if currently executing setViewPosition
    private boolean blocked = false;

    public void alignViewPort(Point mousePosition) {
        // if the scale didn't change there is nothing we should do
        if (scale != lastScale) {
            // compute the factor by that the image zoom has changed
            double scaleChange = scale / lastScale;

            // compute the scaled mouse position
            Point scaledMousePosition = new Point(
                    (int)Math.round(mousePosition.x * scaleChange),
                    (int)Math.round(mousePosition.y * scaleChange)
            );

            // retrieve the current viewport position
            Point viewportPosition = scrollPane.getViewport().getViewPosition();

            // compute the new viewport position
            Point newViewportPosition = new Point(
                    viewportPosition.x + scaledMousePosition.x - mousePosition.x,
                    viewportPosition.y + scaledMousePosition.y - mousePosition.y
            );

            // update the viewport position
            blocked = true;
            scrollPane.getViewport().setViewPosition(newViewportPosition);
            blocked = false;

            // remember the last scale
            lastScale = scale;
        }
    }

    // reference to the scroll pane container
    private final JScrollPane scrollPane;

    // constructor
    public ZoomScrollPanel() {
        // initialize the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // initialize the components
        final ImagePanel imagePanel = new ImagePanel();
        final JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(imagePanel);
        scrollPane = new JScrollPane();

        scrollPane.setViewport(new JViewport() {
            private boolean inCall = false;
            @Override
            public void setViewPosition(Point pos) {
                if (!inCall || !blocked) {
                    inCall = true;
                    super.setViewPosition(pos);
                    inCall = false;
                }
            }
        });

        scrollPane.getViewport().add(centerPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        // add mouse wheel listener
        imagePanel.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                // check the rotation of the mousewheel
                int rotation = e.getWheelRotation();
                boolean zoomed = false;
                if (rotation > 0) {
                    // only zoom out until no scrollbars are visible
                    if (scrollPane.getHeight() < imagePanel.getPreferredSize().getHeight() ||
                            scrollPane.getWidth() < imagePanel.getPreferredSize().getWidth()) {
                        zoom = zoom / 1.3;
                        zoomed = true;
                    }
                } else {
                    // zoom in until maximum zoom size is reached
                    double newCurrentZoom = zoom * 1.3;
                    if (newCurrentZoom < 1000) { // 1000 ~ 10 times zoom
                        zoom = newCurrentZoom;
                        zoomed = true;
                    }
                }
                // check if a zoom happened
                if (zoomed) {
                    // compute the scale
                    scale = (float) (zoom / 100f);

                    // align our viewport
                    alignViewPort(e.getPoint());

                    // invalidate and repaint to update components
                    imagePanel.revalidate();
                    scrollPane.repaint();
                }
            }
        });

        // display our frame
        frame.setVisible(true);
    }

    // the main method
    public static void main(String[] args) {
        new ZoomScrollPanel();
    }
}