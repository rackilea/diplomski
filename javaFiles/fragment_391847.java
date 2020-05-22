import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class MyWormMain {

   private static void createAndShowGui() {
      MyWormDrawPanel drawPanel = new MyWormDrawPanel();
      MyWormButtonPanel btnPanel = new MyWormButtonPanel(drawPanel);

      JFrame frame = new JFrame("Worms");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(drawPanel, BorderLayout.CENTER);
      frame.getContentPane().add(btnPanel.getMainPanel(), BorderLayout.SOUTH);
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
class MyWormDrawPanel extends JPanel {
   private static final int PREF_W = 640;
   private static final int PREF_H = 480;
   private static final Color BACKGROUND = Color.WHITE;
   private static final int TIMER_DELAY = 50;
   private List<MyWorm> wormList = new ArrayList<>();
   private Timer wormTimer;
   private Random random = new Random();

   public MyWormDrawPanel() {
      setBackground(BACKGROUND);
      wormTimer = new Timer(TIMER_DELAY, new WormTimerListener());
      wormTimer.start();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      for (MyWorm worm : wormList) {
         worm.draw(g2);
      }
   }

   public void addWorm() {
      int r = random.nextInt(128) + 128;
      int g = random.nextInt(128) + 128;
      int b = random.nextInt(128) + 128;

      int rand = random.nextInt(3);
      switch (rand) {
      case 0:
         r /= 3;
         break;
      case 1:
         g /= 3;
         break;
      case 2:
         b /= 3;

      default:
         break;
      }
      Color color = new Color(r, g, b);

      int x = random.nextInt(PREF_W);
      int y = random.nextInt(PREF_H);
      Point head = new Point(x, y);
      wormList.add(new MyWorm(color, head, PREF_W, PREF_H));
   }

   public void killWorm() {
      if (wormList.size() > 0) {
         wormList.remove(wormList.size() - 1);
      }
   }

   private class WormTimerListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         for (MyWorm worm : wormList) {
            worm.grow();
         }
         repaint();
      };
   }
}

@SuppressWarnings("serial")
class MyWormButtonPanel {
   private static final int GAP = 15;
   private JPanel mainPanel = new JPanel();
   private MyWormDrawPanel drawPanel;

   public MyWormButtonPanel(MyWormDrawPanel drawPanel) {
      this.drawPanel = drawPanel;
      mainPanel.setLayout(new GridLayout(1, 0, GAP, GAP));
      mainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      mainPanel.add(new JButton(new AddWormAction("Add Worm", KeyEvent.VK_A)));
      mainPanel.add(new JButton(new KillWormAction("Kill Worm", KeyEvent.VK_K)));
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   private class AddWormAction extends AbstractAction {

      public AddWormAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         drawPanel.addWorm();
      }
   }

   private class KillWormAction extends AbstractAction {

      public KillWormAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         drawPanel.killWorm();
      }
   }

}

class MyWorm {
   private static final int MAX_DIR = 360;
   private static final int SEG_WIDTH = 20;
   private static final int MAX_RAND_DIR = 60;
   private Color color;
   private List<Point> body = new ArrayList<>();
   private Random random = new Random();
   private int direction;
   private int maxX;
   private int maxY;

   public MyWorm(Color color, Point head, int maxX, int maxY) {
      this.color = color;
      body.add(head);
      direction = random.nextInt(MAX_DIR);
      this.maxX = maxX;
      this.maxY = maxY;
   }

   public void grow() {
      Point lastPt = body.get(body.size() - 1);
      int x = lastPt.x
            + (int) (SEG_WIDTH * 3 * Math.cos(Math.toRadians(direction)) / 4.0);
      int y = lastPt.y
            + (int) (SEG_WIDTH * 3 * Math.sin(Math.toRadians(direction)) / 4.0);

      if (x < 0) {
         x = maxX - 1;
      } 
      if (x > maxX) {
         x = 0;
      }
      if (y < 0) {
         y = maxY - 1;
      }
      if (y > maxY) {
         y = 0;
      }

      Point nextPoint = new Point(x, y);
      direction += random.nextInt(MAX_RAND_DIR) - MAX_RAND_DIR / 2;

      body.add(nextPoint);
   }

   public void draw(Graphics2D g2) {
      Graphics2D g2b = (Graphics2D) g2.create();
      g2b.setColor(color);
      for (Point p : body) {
         int x = p.x - SEG_WIDTH / 2;
         int y = p.y - SEG_WIDTH / 2;
         int width = SEG_WIDTH;
         int height = SEG_WIDTH;
         g2b.fillOval(x, y, width, height);
      }
      g2b.dispose();
   }

}