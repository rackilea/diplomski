import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ThreeWayGradient {

    public static void main(String[] args) {
        final BufferedImage image = new BufferedImage(
                200, 200, BufferedImage.TYPE_INT_RGB);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Graphics2D g = image.createGraphics();
                GradientPaint primary = new GradientPaint(
                        0f, 0f, Color.WHITE, 200f, 0f, Color.ORANGE);
                GradientPaint shade = new GradientPaint(
                        0f, 0f, new Color(0, 0, 0, 0),
                        0f, 200f, new Color(0, 0, 0, 255));
                g.setPaint(primary);
                g.fillRect(0, 0, 200, 200);
                g.setPaint(shade);
                g.fillRect(0, 0, 200, 200);

                JLabel l = new JLabel(new ImageIcon(image));
                JOptionPane.showMessageDialog(null, l);
                File f = new File(System.getProperty("user.home"),
                        "ThreeWayGradient.png");
                try {
                    ImageIO.write(image, "png", f);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        SwingUtilities.invokeLater(r);
    }
}