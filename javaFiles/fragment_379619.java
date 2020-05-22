import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MyBackground extends JPanel {
   public static final double NORM_CONST = 1.0;
   private BufferedImage img;
   private List<List<Point2D>> normalizedPoints = new ArrayList<List<Point2D>>();
   private List<Point2D> pointSubList;

   public MyBackground(BufferedImage img) {
      this.img = img;
      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
      }
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

      for (List<Point2D> pointList : normalizedPoints) {
         if (pointList.size() > 1) {
            for (int i = 1; i < pointList.size(); i++) {
               Point p1 = deNormalize(pointList.get(i - 1));
               Point p2 = deNormalize(pointList.get(i));
               g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
         }
      }

      if (pointSubList != null && pointSubList.size() > 1) {
         for (int i = 1; i < pointSubList.size(); i++) {
            Point p1 = deNormalize(pointSubList.get(i - 1));
            Point p2 = deNormalize(pointSubList.get(i));
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
         }
      }
   }

   private Point deNormalize(Point2D p2d) {
      int x = (int) (p2d.getX() * getWidth() / NORM_CONST);
      int y = (int) (p2d.getY() * getHeight() / NORM_CONST);
      return new Point(x, y);
   }

   private class MyMouseAdapter extends MouseAdapter {

      @Override
      public void mousePressed(MouseEvent e) {
         Point2D p = normalizePoint(e.getPoint());
         pointSubList = new ArrayList<>();
         pointSubList.add(p);
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         Point2D p = normalizePoint(e.getPoint());
         pointSubList.add(p);
         normalizedPoints.add(pointSubList);
         pointSubList = null;
         repaint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         Point2D p = normalizePoint(e.getPoint());
         pointSubList.add(p);
         repaint();
      }

      private Point2D normalizePoint(Point point) {
         double x = (NORM_CONST * point.x) / getWidth();
         double y = (NORM_CONST * point.y) / getHeight();
         Point2D result = new Point2D.Double(x, y);
         return result;
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