import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawOnLabel extends JLabel {
   public static final String GIRAFFE_IMG_URL = "http://upload.wikimedia.org/wikipedia/commons/thumb" +
        "/9/9e/Giraffe_Mikumi_National_Park.jpg/474px-Giraffe_Mikumi_National_Park.jpg";
   private static final Color LINES_COLOR = Color.red;
   private static final Color CURRENT_LINE_COLOR = new Color(255, 200, 200);
   private List<Line2D> lineList = new ArrayList<Line2D>();
   private Line2D currentLine = null;

   public DrawOnLabel() throws IOException {
      URL giraffeUrl = new URL(GIRAFFE_IMG_URL);
      BufferedImage img = ImageIO.read(giraffeUrl);
      ImageIcon icon = new ImageIcon(img);
      setIcon(icon);

      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

      g2.setColor(LINES_COLOR);
      for (Line2D line : lineList) {
         g2.draw(line);
      }
      if (currentLine != null) {
         g2.setColor(CURRENT_LINE_COLOR);
         g2.draw(currentLine);
      }
   }

   private class MyMouseAdapter extends MouseAdapter {
      Point p1 = null;

      @Override
      public void mousePressed(MouseEvent e) {
         p1 = e.getPoint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         if (currentLine != null) {
            currentLine = new Line2D.Double(p1, e.getPoint());
            lineList.add(currentLine);
            currentLine = null;
            p1 = null;
            repaint();
         }
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         if (p1 != null) {
            currentLine = new Line2D.Double(p1, e.getPoint());
            repaint();
         }

      }
   }

   private static void createAndShowGui() {
      DrawOnLabel mainPanel = null;
      try {
         mainPanel = new DrawOnLabel();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

      JFrame frame = new JFrame("DrawOnLabel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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