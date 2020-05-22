import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MyBackground extends JPanel {
   private BufferedImage img;

   public MyBackground(BufferedImage img) {
      this.img = img;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
      }
   }

   private static void createAndShowGui() {
      String comfyChair = "https://duke.kenai.com/comfyChair/ComfyChairRad.png";
      BufferedImage img;
      try {
         URL url = new URL(comfyChair);
         img = ImageIO.read(url);

         MyBackground mainPanel = new MyBackground(img);

         JFrame frame = new JFrame("MyBackground");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().add(mainPanel);
         frame.pack();
         frame.setLocationByPlatform(true);
         frame.setVisible(true);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}