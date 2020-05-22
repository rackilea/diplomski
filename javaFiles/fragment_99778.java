import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class DailAnimation extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = 350;
   private static final Point2D CENTER = new Point2D.Double(PREF_W / 2.0,
         PREF_W / 2.0);
   private static final double RADIUS = PREF_W / 2.0;
   private static final Color LARGE_TICK_COLOR = Color.green;
   private static final Color CENTER_HUB_COLOR = Color.LIGHT_GRAY;
   private static final Stroke LARGE_TICK_STROKE = new BasicStroke(3f);
   private static final int LRG_TICK_COUNT = 9;
   private static final double TOTAL_LRG_TICKS = 12;
   private static final double LRG_TICK_OUTER_RAD = 0.9;
   private static final double LRG_TICK_INNER_RAD = 0.8;
   private static final int START_TICK = 10;
   private static final double CENTER_HUB_RADIUS = 10;
   public static final int MAX_SPEED = 100;
   private static final double INIT_SPEED = 0;
   private static final double DIAL_INNER_RAD = 0.02;
   private static final double DIAL_OUTER_RAD = 0.75;
   private static final Color DIAL_COLOR = Color.DARK_GRAY;
   private BufferedImage backgroundImg;

   private double speed;
   private double theta;
   private double cosTheta;
   private double sinTheta;

   public DailAnimation() {
      setBackground(Color.white);

      backgroundImg = createBackgroundImg();
      setSpeed(INIT_SPEED);
   }

   public void setSpeed(double speed) {
      if (speed < 0) {
         speed = 0;
      } else if (speed > MAX_SPEED) {
         speed = MAX_SPEED;
      }
      this.speed = speed;
      this.theta = ((speed / MAX_SPEED) * LRG_TICK_COUNT * 2.0 + START_TICK)
            * Math.PI / TOTAL_LRG_TICKS;
      cosTheta = Math.cos(theta);
      sinTheta = Math.sin(theta);

      repaint();
   }

   private BufferedImage createBackgroundImg() {
      BufferedImage img = new BufferedImage(PREF_W, PREF_H,
            BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();

      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(LARGE_TICK_COLOR);
      g2.setStroke(LARGE_TICK_STROKE);

      for (int i = 0; i < LRG_TICK_COUNT; i++) {
         double theta = (i * 2.0 + START_TICK) * Math.PI / TOTAL_LRG_TICKS;
         double cosTheta = Math.cos(theta);
         double sinTheta = Math.sin(theta);

         int x1 = (int) (LRG_TICK_INNER_RAD * RADIUS * cosTheta + CENTER.getX());
         int y1 = (int) (LRG_TICK_INNER_RAD * RADIUS * sinTheta + CENTER.getY());
         int x2 = (int) (LRG_TICK_OUTER_RAD * RADIUS * cosTheta + CENTER.getX());
         int y2 = (int) (LRG_TICK_OUTER_RAD * RADIUS * sinTheta + CENTER.getY());

         g2.drawLine(x1, y1, x2, y2);
      }

      g2.setColor(CENTER_HUB_COLOR);

      int x = (int) (CENTER.getX() - CENTER_HUB_RADIUS);
      int y = (int) (CENTER.getY() - CENTER_HUB_RADIUS);
      int width = (int) (2 * CENTER_HUB_RADIUS);
      int height = width;
      g2.fillOval(x, y, width, height);
      // g2.draw(ellipse);

      g2.dispose();
      return img;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (backgroundImg != null) {
         g.drawImage(backgroundImg, 0, 0, this);
      }

      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

      g.setColor(DIAL_COLOR);
      int x1 = (int) (DIAL_INNER_RAD * RADIUS * cosTheta + CENTER.getX());
      int y1 = (int) (DIAL_INNER_RAD * RADIUS * sinTheta + CENTER.getY());
      int x2 = (int) (DIAL_OUTER_RAD * RADIUS * cosTheta + CENTER.getX());
      int y2 = (int) (DIAL_OUTER_RAD * RADIUS * sinTheta + CENTER.getY());

      g.drawLine(x1, y1, x2, y2);

   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      final DailAnimation mainPanel = new DailAnimation();

      JFrame frame = new JFrame("DailAnimation");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);

      int delay = 100;
      new Timer(delay, new ActionListener() {
         int speed = 0;

         @Override
         public void actionPerformed(ActionEvent evt) {
            speed ++;
            if (speed > DailAnimation.MAX_SPEED) {
               ((Timer)evt.getSource()).stop();
            }
            mainPanel.setSpeed(speed);
         }
      }).start();
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}