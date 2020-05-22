import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

class TestBrightness {
    public static void main(String args[]) {
        try {
            URL imageUrl = new URL(
                    "http://duke.kenai.com/comfyChair/ComfyChairRadSmall.jpg");

            BufferedImage ioImage = ImageIO.read(imageUrl);

            JPanel panel = new JPanel();
            Image scaledImg = ioImage.getScaledInstance(ioImage.getWidth() / 2, 
                    ioImage.getHeight() / 2, Image.SCALE_SMOOTH);

            panel.add(new JLabel(new ImageIcon(ioImage)));
            panel.add(new JLabel(new ImageIcon(scaledImg)));

            JOptionPane.showMessageDialog(null, panel, "100% vs 50%",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Failure",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}