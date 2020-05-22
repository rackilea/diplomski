import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageDisplay {
    public static final String IMG_URL_PATH = "https://upload.wikimedia.org/"
            + "wikipedia/commons/thumb/1/1a/" 
            + "WomanFactory1940s.jpg/773px-WomanFactory1940s.jpg";

    private static void createAndShowGui() {
        BufferedImage img = null;

        try {
            URL imageUrl = new URL(IMG_URL_PATH);
            img = ImageIO.read(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        Icon icon = new ImageIcon(img);
        JLabel label = new JLabel(icon);

        JFrame frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}