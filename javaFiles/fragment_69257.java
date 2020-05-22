import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BigDukeImage {
   public static final String IMAGE_PATH = "http://" + "duke.kenai.com/nyanya/NyaNya.jpg";
   private static final Dimension SCROLLPANE_SIZE = new Dimension(900, 700);

   private static void createAndShowUI() {
      Image image = null;
      try {
         URL url = new URL(IMAGE_PATH);
         image = ImageIO.read(url);
         // JLabel label = new JLabel(new ImageIcon(image));
         ImagePanelA imagePanel = new ImagePanelA(image);

         JScrollPane scrollpane = new JScrollPane();
         // scrollpane.getViewport().add(label);
         scrollpane.getViewport().add(imagePanel);
         scrollpane.setPreferredSize(SCROLLPANE_SIZE);

         JFrame frame = new JFrame("Big Duke Image");
         frame.getContentPane().add(scrollpane);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);

         JScrollBar vertSBar = scrollpane.getVerticalScrollBar();
         JScrollBar horzSBar = scrollpane.getHorizontalScrollBar();

         vertSBar.setValue((vertSBar.getMaximum() - vertSBar.getVisibleAmount()) / 2);
         horzSBar.setValue((horzSBar.getMaximum() - horzSBar.getVisibleAmount()) / 2);

      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}

@SuppressWarnings("serial")
class ImagePanelA extends JPanel {

   private Image image;

   public ImagePanelA(Image image) {
      this.image = image;
      setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (image != null) {
         g.drawImage(image, 0, 0, null);
      }
   }
}