import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CatchMonster extends JPanel {
   private int height = 300;
   private int width = 600;
   private final int delay = 4001;

   private ImageIcon image;
   private Timer timer;
   private int x, y, moveX, moveY, xPoint, yPoint;
   private List<Point> points = new ArrayList<Point>();

   public CatchMonster() {

      DotListener dot = new DotListener();
      addMouseListener(dot);

      timer = new Timer(delay, new timerListener());
      x = 40;
      y = 40;

      moveX = moveY = 3;
      setPreferredSize(new Dimension(width, height));
      setBackground(Color.black);
      timer.start();

   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.yellow);
      g.fillOval(x, y, 60, 60);

      int radius = 30;
      g.setColor(Color.green);
      for (Point p : points) {
         int x = p.x - radius;
         int y = p.y - radius;
         g.fillOval(x, y, 2 * radius, 2 * radius);
      }
   }

   private class timerListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         Random gn = new Random();
         x = gn.nextInt(width);
         y = gn.nextInt(height);

         repaint();
      }
   }

   public static void main(String[] args) {
      JFrame frame = new JFrame("Foo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new CatchMonster());
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   private class DotListener extends MouseAdapter {
      public void mousePressed(MouseEvent event) {
         points.add(event.getPoint());
         repaint();
      }

   }
}