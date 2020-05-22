import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
    public static final String IMG_URL_PATH = "https://upload.wikimedia.org/"
            + "wikipedia/commons/thumb/1/1a/" 
            + "WomanFactory1940s.jpg/773px-WomanFactory1940s.jpg";
    private BufferedImage image;

    public ImagePanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // if the image isn't null, draw it in the JPanel
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // if either the image is null or the panel's preferred size
        // has been set, then must use the super's value
        if (isPreferredSizeSet() || image == null) {
            return super.getPreferredSize();
        } else {
            // otherwise use the image's size for the panel's pref'd size
            int width = image.getWidth();
            int height = image.getHeight();
            return new Dimension(width, height);
        }
    }

    private static void createAndShowGui(BufferedImage img) {
        ImagePanel mainPanel = new ImagePanel(img);

        JFrame frame = new JFrame("Image Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // first add all components to the JFrame
        frame.getContentPane().add(mainPanel);

        // pack the JFrame to allow it to size all its components and itself
        frame.pack();

        // call this *after* packing only if you want the size fixed
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // then display it
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            URL imageUrl = new URL(IMG_URL_PATH);
            final BufferedImage img = ImageIO.read(imageUrl);
            SwingUtilities.invokeLater(() -> createAndShowGui(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}