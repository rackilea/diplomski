import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImageInScrollPane extends JPanel {
   public static final String IMAGE_PATH = "http://image.desk7.net/"
         + "Space%20Wallpapers/1422_1280x800.jpg";
   private static final int PREF_W = 500;
   private static final int PREF_H = 400;


   public ImageInScrollPane() throws IOException {
      URL imageUrl = new URL(IMAGE_PATH);
      BufferedImage img = ImageIO.read(imageUrl);
      Icon icon = new ImageIcon(img);
      JLabel label = new JLabel(icon);
      JScrollPane scrollPane = new JScrollPane(label);

      setLayout(new BorderLayout());
      add(scrollPane);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      ImageInScrollPane mainPanel = null;
      try {
         mainPanel = new ImageInScrollPane();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

      JFrame frame = new JFrame("ImageInScrollPane");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}