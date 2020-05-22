import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class FooArcs extends JPanel {
   public static final int PREF_W = 500;
   private PiePanel piePanel;
   private JSlider slider = new JSlider(0, 260, 0);

   public FooArcs(int imageWidth, int divisions) {
      slider.setMinorTickSpacing(5);
      slider.setMajorTickSpacing(20);
      slider.setPaintLabels(true);
      slider.setPaintTicks(true);

      piePanel = new PiePanel(imageWidth, divisions);

      slider.addChangeListener(new SliderListener());

      setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      setLayout(new BorderLayout(5, 5));
      add(piePanel, BorderLayout.CENTER);
      add(slider, BorderLayout.PAGE_END);
   }

   private class SliderListener implements ChangeListener {
      @Override
      public void stateChanged(ChangeEvent e) {
         int value = slider.getValue();
         piePanel.rotate(value);
      }
   }

   private static void createAndShowGui() {
      int imageWidth = PREF_W;
      int divisions = 24;
      FooArcs mainPanel = new FooArcs(imageWidth, divisions);

      JFrame frame = new JFrame("FooArcs");
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

@SuppressWarnings("serial")
class PiePanel extends JPanel {
   private BufferedImage image;
   private Random random = new Random();
   private AffineTransform af;
   private int imageWidth;

   public PiePanel(int imageWidth, int divisions) {
      this.imageWidth = imageWidth;
      image = new BufferedImage(imageWidth, imageWidth, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = image.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      for (int i = 0; i < divisions; i++) {
         drawPie(g2, i, imageWidth, divisions);
      }
      g2.dispose();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g.create(); // create a copy to rotate
      if (image != null) {
         if (af != null) {
            g2.transform(af);
         }
         g2.drawImage(image, 0, 0, null);
      }
      g2.dispose(); // OK to do this as we created this object
   }

   private void drawPie(Graphics2D g2, int i, int imageWidth2, int divisions) {
      Color c = getRandomColor();
      double x = 1.0;
      double y = x;
      double w = imageWidth2 - 2;
      double h = w;
      double start = i * 360.0 / divisions; // starting angle
      double extent = 360.0 / divisions; // size of slice in degrees
      int type = Arc2D.PIE;
      Arc2D arc = new Arc2D.Double(x, y, w, h, start, extent, type);

      g2.setColor(c);
      g2.fill(arc);
      g2.setColor(Color.black);
      g2.draw(arc);
   }

   private Color getRandomColor() {
      Integer a = random.nextInt(128) + 128;
      Integer b = random.nextInt(128) + (random.nextBoolean() ? 128 : 0);
      Integer c = random.nextInt(128);
      List<Integer> colors = Arrays.asList(new Integer[] {a, b, c});
      Collections.shuffle(colors);
      Color color = new Color(colors.get(0), colors.get(1), colors.get(2));

      return color;
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(imageWidth, imageWidth);
   }

   public void rotate(int degrees) {
      double theta = Math.toRadians(degrees);
      double anchorx = imageWidth / 2.0;
      double anchory = anchorx;
      af = AffineTransform.getRotateInstance(theta, anchorx, anchory);
      repaint();
   }
}