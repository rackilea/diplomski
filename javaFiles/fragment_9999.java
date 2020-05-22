import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class GraphicsEg extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private List<Shape> shapes = new ArrayList<>();
   private Map<Shape, Color> shapeColorMap = new HashMap<>();

   public GraphicsEg() {
      Shape shape = new Ellipse2D.Double(10, 10, 30, 30);
      shapeColorMap.put(shape, Color.RED);
      shapes.add(shape);

      shape = new Rectangle2D.Double(140, 140, 200, 200);
      shapeColorMap.put(shape, Color.BLUE);
      shapes.add(shape);

      shape = new RoundRectangle2D.Double(200, 200, 80, 80, 10, 10);
      shapeColorMap.put(shape, Color.GREEN);
      shapes.add(shape);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      for (Shape shape : shapes) {
         Color color = shapeColorMap.get(shape);
         g2.setColor(color);
         g2.fill(shape);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }
   private static void createAndShowGui() {
      JFrame frame = new JFrame("GraphicsEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new GraphicsEg());
      frame.pack();
      frame.setLocationRelativeTo(null);
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