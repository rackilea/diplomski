import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

// extend JPanel so you can draw within it
public class SimpleCheckerboard extends JPanel {
   public static final int ROWS = 8;
   private static final int PREF_W = 60 * ROWS;
   private static final int PREF_H = PREF_W;

   public SimpleCheckerboard() {
      // TODO Auto-generated constructor stub
   }

   // the method that does the drawing:
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (int row = 0; row < ROWS; row++) {
         for (int col = 0; col < ROWS; col++) {
            // choose a Color black or white depending on row and col

            Color c = Color.white;
            if (row % 2 == col % 2) {
               c = Color.black;
            }

            // this would work too!
            // Color c = (row % 2 == col % 2) ? Color.BLACK : Color.WHITE;
            g.setColor(c);

            int x = (col * getWidth()) / ROWS;
            int y = (row * getHeight()) / ROWS;
            int w = getWidth() / ROWS;
            int h = getHeight() / ROWS;

            g.fillRect(x, y, w, h);
         }
      }
   }

   @Override  // set size of our GUI
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      SimpleCheckerboard mainPanel = new SimpleCheckerboard();

      JFrame frame = new JFrame("SimpleCheckerboard");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      // call our code in a Swing thread-safe way:
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}