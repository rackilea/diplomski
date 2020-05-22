import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class TestImage {
    public static void main(String args[]) {
        try {
            URL imageUrl = new URL(
                "http://tctechcrunch2011.files.wordpress.com/2012/10/gmm.jpg");
            BufferedImage ioImage = ImageIO.read(imageUrl);
            Image toolkitImage = Toolkit.getDefaultToolkit().createImage(
                    imageUrl);

            JPanel panel = new JPanel();
            panel.add(new JLabel(new ImageIcon(ioImage)));
            panel.add(new JLabel(new ImageIcon(toolkitImage)));

            JOptionPane.showMessageDialog(null, panel, "ImageIO vs Toolkit",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Failure",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}