import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// draw in a JPanel, not a JFrame
public class SimpleAnimation extends JPanel {
   private static final int OVAL_WIDTH = 40;
   private static final int TIMER_DELAY = 50;
   private static final int PREF_W = 800;
   private static final int PREF_H = PREF_W;
   private int xPosition = 0;
   private int yPosition = 0;

   public SimpleAnimation() {
      // start my timer here
      new Timer(TIMER_DELAY, new TimerListener()).start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      // call the super method so that the JPanel
      // can do its own house-keeping graphics first
      super.paintComponent(g);

      // I do this to so that my graphics are smooth 
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(Color.red);

      // use xPosition and yPosition to place my oval
      g2.fillOval(xPosition, yPosition, OVAL_WIDTH, OVAL_WIDTH);
   }

   // so our GUI will be big enough to see
   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   // class used by the Swing Timer to drive animation
   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // change xPosition and yPosition
         xPosition++;
         yPosition++;

         // and call repaint
         repaint();
      }
   }

   // a method to be called in our Runnable
   private static void createAndShowGui() {
      SimpleAnimation mainPanel = new SimpleAnimation();

      JFrame frame = new JFrame("SimpleAnimation");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      // this is used to make sure that all Swing code
      // is started on the Swing event thread.
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}