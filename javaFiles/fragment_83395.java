import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.*;

public class MyPaint extends JComponent {
   private static final int PREF_W = 600;
   private static final int PREF_H = PREF_W;
   private static final Stroke STROKE = new BasicStroke(4f);
   private static final Color[] COLORS = { Color.RED, Color.GREEN,
         Color.yellow, Color.orange, Color.blue, Color.cyan };
   private BufferedImage img = new BufferedImage(PREF_W, PREF_H,
         BufferedImage.TYPE_INT_ARGB);
   private Rectangle rect = null;

   public MyPaint() {
      MyMouse myMouse = new MyMouse();
      addMouseListener(myMouse);
      addMouseMotionListener(myMouse);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, null);
      }
      if (rect != null) {
         g.setColor(Color.LIGHT_GRAY);
         ((Graphics2D) g).draw(rect);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class MyMouse extends MouseAdapter {
      private Random random = new Random();
      private Point p;

      @Override
      public void mousePressed(MouseEvent e) {
         if (e.getButton() != MouseEvent.BUTTON1) {
            return;
         }
         p = e.getPoint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         if (p != null) {
            Rectangle rect2 = createRect(e.getPoint());
            Graphics2D g2 = img.createGraphics();
            g2.setStroke(STROKE);
            Color c = COLORS[random.nextInt(COLORS.length)];
            g2.setColor(c);
            g2.fill(rect2);
            g2.setColor(c.darker());
            g2.draw(rect2);
            g2.dispose();
         }

         p = null;
         rect = null;
         repaint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         rect = createRect(e.getPoint());
         repaint();
      }

      private Rectangle createRect(Point p2) {
         int x = Math.min(p.x, p2.x);
         int y = Math.min(p.y, p2.y);
         int width = Math.abs(p.x - p2.x);
         int height = Math.abs(p.y - p2.y);
         Rectangle rect2 = new Rectangle(x, y, width, height);
         return rect2;
      }

   }

   private static void createAndShowGui() {
      MyPaint mainPanel = new MyPaint();

      JFrame frame = new JFrame("MyPaint");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.setResizable(false);
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