import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestImage {

    public static void main(String[] args) {
        new TestImage();
    }

    public TestImage() {
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

        private BufferedImage original;

        public TestPane() {
            try {
                original = ImageIO.read(new File("Your image here"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public Image scaleAndRotate(Image image, int sizeX, int sizeY, double degrees) {

            double scaleWidth = (double)sizeX / (double)image.getWidth(this);
            double scaleHeight = (double)sizeY / (double)image.getHeight(this);
            BufferedImage img = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            AffineTransform at = new AffineTransform();
            at.scale(scaleWidth, scaleHeight);
            at.rotate(Math.toRadians(degrees), image.getWidth(this) / 2d, image.getHeight(this) / 2d);
            g2d.setTransform(at);
            g2d.drawImage(image, sizeX / 2, sizeY / 2, null);
            g2d.dispose();

            return img;

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int scaleWidth = getWidth() / 2;
            int scaleHeight = getHeight() / 2;

            Image img = scaleAndRotate(original, scaleWidth, scaleHeight, 45.0);
            int x = (getWidth() - img.getWidth(this)) / 2;
            int y = (getHeight()- img.getHeight(this)) / 2;

            g2d.drawImage(img, x, y, this);
            g2d.dispose();
        }

    }

}