import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Capture {

    private static final int WIDTH = 128;
    private static final int HEIGHT = 128;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
            BufferedImage.TYPE_INT_RGB);

    public void capture(Component component) {
        component.setSize(image.getWidth(), image.getHeight());

        Graphics2D g = image.createGraphics();
        try {
            component.paint(g);
        } finally {
            g.dispose();
        }
    }

    private BufferedImage getScaledImage(int width, int height) {
        BufferedImage buffer = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffer.createGraphics();
        try {
            g.drawImage(image, 0, 0, width, height, null);
        } finally {
            g.dispose();
        }
        return buffer;
    }

    public void save(File png, int width, int height) throws IOException {
        ImageIO.write(getScaledImage(width, height), "png", png);
    }

    public static void main(String[] args) throws IOException {
        JLabel label = new JLabel();
        label.setText("Hello, World!");
        label.setOpaque(true);

        Capture cap = new Capture();
        cap.capture(label);
        cap.save(new File("foo.png"), 64, 64);
    }

}