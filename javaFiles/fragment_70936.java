import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class Gui2 {
   JFrame frame = new JFrame();
   MyDrawPanel drawpanel = new MyDrawPanel();

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            Gui2 gui = new Gui2();
            gui.go();
         }
      });
   }

   public void go() {
      frame.getContentPane().add(drawpanel);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }
}

class MyDrawPanel extends JComponent {
   private static final int PREF_W = 240;
   private static final int PREF_H = PREF_W;
   private static final double RGB_MAX = 255;
   private static final double ELLIPSE_X = 70;
   private static final double ELLIPSE_WIDTH = PREF_W - 2 * ELLIPSE_X;
   private int red;
   private int green;
   private int blue;
   private Color startrandomColor;
   private Color endrandomColor;
   private Ellipse2D ellipse = new Ellipse2D.Double(ELLIPSE_X, ELLIPSE_X,
         ELLIPSE_WIDTH, ELLIPSE_WIDTH);

   public MyDrawPanel() {
      addMouseListener(new MyMouseAdapter());
      setRandomGradient();
   }

   private void setRandomGradient() {
      red = (int) (Math.random() * RGB_MAX);
      green = (int) (Math.random() * RGB_MAX);
      blue = (int) (Math.random() * RGB_MAX);
      startrandomColor = new Color(red, green, blue);
      red = (int) (Math.random() * RGB_MAX);
      green = (int) (Math.random() * RGB_MAX);
      blue = (int) (Math.random() * RGB_MAX);
      endrandomColor = new Color(red, green, blue);
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      GradientPaint gradient = new GradientPaint(70, 70, startrandomColor, 150,
            150, endrandomColor);

      g2d.setPaint(gradient);
      g2d.fill(ellipse);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent e) {
         if (ellipse.contains(e.getPoint())) {
            setRandomGradient();
            repaint();
         }
      }
   }
}