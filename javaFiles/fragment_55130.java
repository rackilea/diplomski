import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class SimpleTestImage {
   public static void main(String[] args) {
      String path = "spells.png";
      InputStream inputStream = SimpleTestImage.class.getResourceAsStream(path);
      try {
         BufferedImage img = ImageIO.read(inputStream);
         ImageIcon icon = new ImageIcon(img);
         JOptionPane.showMessageDialog(null, icon);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}