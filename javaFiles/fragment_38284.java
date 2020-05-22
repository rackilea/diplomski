import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class PaintComponentCorrect extends JPanel {
   public static final String BULL_FIGHT = "https://duke.kenai.com/misc/Bullfight.jpg";
   private static final Color RECT_COLOR = new Color(150, 150, 255);
   private int startX;
   private int startY;
   private int endX;
   private int endY;
   private BufferedImage img;

   public PaintComponentCorrect() throws IOException {
      URL url = new URL(BULL_FIGHT);
      img = ImageIO.read(url);

      MyMouseAdapt myMouseAdapt = new MyMouseAdapt();
      addMouseListener(myMouseAdapt);
      addMouseMotionListener(myMouseAdapt);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, null);
      }
      g.setColor(RECT_COLOR);
      int x = Math.min(startX, endX);
      int y = Math.min(startY, endY);
      int width = Math.abs(startX - endX);
      int height = Math.abs(startY - endY);
      g.drawRect(x, y, width, height);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet() || img == null) {
         return super.getPreferredSize();
      }
      return new Dimension(img.getWidth(), img.getHeight());
   }

   private class MyMouseAdapt extends MouseAdapter {
      private BufferedImage subImg;

      @Override
      public void mousePressed(MouseEvent e) {
         if (e.getButton() != MouseEvent.BUTTON1) {
            return;
         }
         startX = e.getX();
         startY = e.getY();
         endX = startX;
         endY = startY;
         repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         if (e.getButton() != MouseEvent.BUTTON1) {
            return;
         }
         endX = e.getX();
         endY = e.getY();
         repaint();
         int x = Math.min(startX, endX);
         int y = Math.min(startY, endY);
         int w = Math.abs(startX - endX);
         int h = Math.abs(startY - endY);


         subImg = img.getSubimage(x, y, w, h);
         ImageIcon icon = new ImageIcon(subImg);
         JOptionPane.showMessageDialog(PaintComponentCorrect.this, icon);
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         endX = e.getX();
         endY = e.getY();
         repaint();
      }
   }

   private static void createAndShowGui() {
      PaintComponentCorrect mainPanel = null;
      try {
         mainPanel = new PaintComponentCorrect();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

      JFrame frame = new JFrame("PaintComponent Correct");
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