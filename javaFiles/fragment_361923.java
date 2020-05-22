import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class BufferedImageEg extends JPanel {
   private static final int BI_WIDTH = 700;
   private static final int BI_HEIGHT = 500;
   private static final Color BACKGROUND = new Color(255, 255, 240);
   private static final int THIS_PT_WIDTH = 12;
   private static final int THIS_PT_HEIGHT = THIS_PT_WIDTH;
   private static final float THIS_PT_STROKE_WIDTH = 2f;
   private static final Color THIS_PT_BORDER_COLOR = Color.red;
   private static final Color THIS_PT_FILL_COLOR = new Color(250, 250, 0, 125);
   private static final int TIMER_DELAY = 30;
   private static final int X_MIN = 0;
   private static final int X_MAX = 100;
   private static final double X_STEP = 0.1;
   private static final double X_SCALE = (double) BI_WIDTH
         / ((double) X_MAX - X_MIN);
   private static final double Y_SCALE = 8;
   private static final float LINE_WIDTH = 4;
   private static final Color LINE_COLOR = Color.blue;

   private Point lastPoint = null;
   private Point thisPoint = null;

   private BufferedImage bImage = new BufferedImage(BI_WIDTH, BI_HEIGHT,
         BufferedImage.TYPE_INT_RGB);
   private double xValue = X_MIN;

   public BufferedImageEg() {
      Graphics biG = bImage.getGraphics();
      biG.setColor(BACKGROUND);
      biG.fillRect(0, 0, BI_WIDTH, BI_HEIGHT);
      setBackground(BACKGROUND);
      new Timer(TIMER_DELAY, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            timerActionPerformed(e);
         }
      }).start();
   }

   private void timerActionPerformed(ActionEvent e) {
      if (xValue <= X_MAX) {
         lastPoint = thisPoint;
         double tempX = xValue;
         double yValue = function(xValue);

         tempX *= X_SCALE;
         yValue *= Y_SCALE;
         yValue = BI_HEIGHT / 2.0 - yValue;

         thisPoint = new Point((int) tempX, (int) yValue);

         if (lastPoint != null) {
            drawInBufferedImage();
         }

         xValue += X_STEP;
      } else {
         ((Timer) e.getSource()).stop();
         thisPoint = null;
      }
      repaint();
   }

   private void drawInBufferedImage() {
      Graphics2D g2 = bImage.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setStroke(new BasicStroke(LINE_WIDTH, BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_ROUND));
      g2.setColor(LINE_COLOR);
      int x1 = lastPoint.x;
      int y1 = lastPoint.y;
      int x2 = thisPoint.x;
      int y2 = thisPoint.y;
      g2.drawLine(x1, y1, x2, y2);
      g2.dispose();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(BI_WIDTH, BI_HEIGHT);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(bImage, 0, 0, null);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

      if (thisPoint != null) {
         drawThisPoint(g2);
      }
   }

   private void drawThisPoint(Graphics2D g2) {
      int x = thisPoint.x - THIS_PT_WIDTH / 2;
      int y = thisPoint.y - THIS_PT_HEIGHT / 2;
      Graphics2D g2b = (Graphics2D) g2.create();
      g2b.setStroke(new BasicStroke(THIS_PT_STROKE_WIDTH));
      g2b.setColor(THIS_PT_FILL_COLOR);
      g2b.fillOval(x, y, THIS_PT_WIDTH, THIS_PT_HEIGHT);
      g2b.setColor(THIS_PT_BORDER_COLOR);
      g2b.drawOval(x, y, THIS_PT_WIDTH, THIS_PT_HEIGHT);
      g2b.dispose();
   }

   private double function(double x) {
      return 24 * Math.sin(x / 12.0) * Math.sin(x);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("BufferedImage Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new BufferedImageEg());
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