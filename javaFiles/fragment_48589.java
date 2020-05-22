import java.awt.Image;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageLoader {

    public static void main(String[] args) throws IOException {
        InputStream is = ImageLoader.class.getResourceAsStream("/resource/images/alphabet.png");
        Image image = ImageIO.read(is);
        JLabel label = new JLabel(new ImageIcon(image));
        JOptionPane.showMessageDialog(null, label);

    }
}