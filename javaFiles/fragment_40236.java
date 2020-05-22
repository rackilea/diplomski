import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = 400;
   private static final Color DRAWING_COLOR = new Color(255, 100, 200);
   private static final Color FINAL_DRAWING_COLOR = Color.red;

   private BufferedImage backgroundImg;
   private Point startPt = null;
   private Point endPt = null;
   private Point currentPt = null;

   public DrawingPanel() {
      backgroundImg = new BufferedImage(PREF_W, PREF_H,
            BufferedImage.TYPE_INT_ARGB);
      Graphics g = backgroundImg.getGraphics();
      g.setColor(Color.blue);
      g.fillRect(0, 0, PREF_W, PREF_H);
      g.dispose();

      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseMotionListener(myMouseAdapter);
      addMouseListener(myMouseAdapter);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (backgroundImg != null) {
         g.drawImage(backgroundImg, 0, 0, this);
      }

      if (startPt != null && currentPt != null) {
         g.setColor(DRAWING_COLOR);
         int x = Math.min(startPt.x, currentPt.x);
         int y = Math.min(startPt.y, currentPt.y);
         int width = Math.abs(startPt.x - currentPt.x);
         int height = Math.abs(startPt.y - currentPt.y);
         g.drawRect(x, y, width, height);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public void drawToBackground() {
      Graphics g = backgroundImg.getGraphics();
      g.setColor(FINAL_DRAWING_COLOR);
      int x = Math.min(startPt.x, endPt.x);
      int y = Math.min(startPt.y, endPt.y);
      int width = Math.abs(startPt.x - endPt.x);
      int height = Math.abs(startPt.y - endPt.y);
      g.drawRect(x, y, width, height);
      g.dispose();

      startPt = null;
      repaint();
   }

   private class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mouseDragged(MouseEvent mEvt) {
         currentPt = mEvt.getPoint();
         DrawingPanel.this.repaint();
      }

      @Override
      public void mouseReleased(MouseEvent mEvt) {
         endPt = mEvt.getPoint();
         currentPt = null;
         drawToBackground();
      }

      @Override
      public void mousePressed(MouseEvent mEvt) {
         startPt = mEvt.getPoint();
      }
   }

   private static void createAndShowGui() {
      DrawingPanel mainPanel = new DrawingPanel();

      JFrame frame = new JFrame("Drawing Panel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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