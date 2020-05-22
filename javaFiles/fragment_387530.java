import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {
   private static void createAndShowGui() {
      JFrame frame = new JFrame("Main");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new MyMainUI());
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

@SuppressWarnings("serial")
class MyMainUI extends JPanel {
   public static final String IMG_URL_PATH = "http://duke.kenai.com/Oracle/OracleStrat.png";
   private static final int PREF_W = 900;
   private static final int PREF_H = 650; 
   private JLabel thumbLbl = new JLabel();
   private JButton thumbBtn = new JButton("Get Image");

   public MyMainUI() {      
      thumbBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            thumbBtn.setEnabled(false);
            final ImageDownloader imgDownLoader = new ImageDownloader(IMG_URL_PATH);
            imgDownLoader.execute();

            imgDownLoader.addPropertyChangeListener(new ImgDownLoaderListener(imgDownLoader));
         }
      });

      JPanel btnPanel = new JPanel();
      btnPanel.add(thumbBtn);

      setLayout(new BorderLayout());
      add(new JScrollPane(thumbLbl), BorderLayout.CENTER);
      add(btnPanel, BorderLayout.PAGE_END);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class ImgDownLoaderListener implements PropertyChangeListener {
      ImageDownloader imgDownLoader;

      public ImgDownLoaderListener(ImageDownloader imgDownLoader) {
         this.imgDownLoader = imgDownLoader;
      }

      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         // swing worker is done
         if (evt.getNewValue().equals(SwingWorker.StateValue.DONE)) {
            thumbBtn.setEnabled(true);
            try {
               ImageIcon icon = imgDownLoader.get();
               if (icon != null) {
                  thumbLbl.setIcon(icon);
               }
            } catch (InterruptedException e) {
               e.printStackTrace();
            } catch (ExecutionException e) {
               e.printStackTrace();
            }
         }
      }
   }
}



class ImageDownloader extends SwingWorker<ImageIcon, Void> {
   private String imageUrlPath;

   public ImageDownloader(String imageUrlPath) {
      this.imageUrlPath = imageUrlPath;
   }

   @Override
   protected ImageIcon doInBackground() throws Exception {
      try {
         URL imgUrl = new URL(imageUrlPath);
         BufferedImage img = ImageIO.read(imgUrl);
         return new ImageIcon(img); // return the ImageIcon
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return null; // or return null if an error occurs
   }

}