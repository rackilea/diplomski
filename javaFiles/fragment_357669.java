import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game2 extends JPanel {
   public static final String INTRO = "intro";
   public static final String GAME = "game";
   public static final int FPS = 15;
   private CardLayout cardLayout = new CardLayout();

   public Game2() throws IOException {
      URL imgUrl = new URL(IntroScreen.IMAGE_PATH);
      BufferedImage img = ImageIO.read(imgUrl);
      IntroScreen introScreen = new IntroScreen(img);
      introScreen.setLayout(new BorderLayout());

      JButton startButton = new JButton(new StartAction("Start"));
      JPanel bottomPanel = new JPanel();
      bottomPanel.setOpaque(false);
      bottomPanel.add(startButton);
      introScreen.add(bottomPanel, BorderLayout.PAGE_END);

      setLayout(cardLayout);
      add(introScreen, INTRO);
   }

   private class StartAction extends AbstractAction {
      public StartAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         GamePanel gamePanel = new GamePanel(FPS);
         Game2.this.add(gamePanel, GAME);
         cardLayout.show(Game2.this, GAME);
         gamePanel.start();
      }
   }

   private static void createAndShowGui() {
      Game2 game2 = null;
      try {
         game2 = new Game2();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

      JFrame frame = new JFrame("Game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(game2);
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

@SuppressWarnings("serial")
class IntroScreen extends JPanel {
   public static final String IMAGE_PATH = "https://duke.kenai.com/"
         + "glassfish/GlassFishMedium.jpg";
   private BufferedImage img;

   public IntroScreen(BufferedImage img) {
      this.img = img;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, this);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (img != null) {
         int width = img.getWidth();
         int height = img.getHeight();
         return new Dimension(width, height);
      }
      return super.getPreferredSize();
   }
}

@SuppressWarnings("serial")
class GamePanel extends JPanel {
   protected static final int DX = 2;
   protected static final int DY = DX;
   private int x;
   private int y;
   private Timer timer;
   private int fps = 0;

   public GamePanel(int fps) {
      this.fps = fps;
   }

   @Override 
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       //Background
       g2d.setPaint(Color.BLACK);
       g2d.fillRect(0, 0, 820, 650);
       //Anti-aliasing 
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

       g2d.setPaint(Color.BLUE);
       g2d.fillOval(x, y, 70, 70);
   }

   public void start() {
      // use a field called timer
      timer = new Timer(fps, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // get this out of the paintComponent method
            x += DX;
            y += DY;
            repaint();
         }
      });
      timer.start();
   }
}