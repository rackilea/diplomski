import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleNumberLinePanel extends JPanel {

   private static final int PREF_W = 800;
   private static final int PREF_H = 300;
   private static final int GAP = 10;
   private static final int START = 0;
   private static final int END = 12;
   private static final int VERT_LINE_HEIGHT = 20;
   private static final Font FONT = new Font(Font.MONOSPACED, Font.BOLD, 14);
   private static final int TEXT_GAP = 2;

   @Override
   protected void paintComponent(Graphics g) {
      // call super method
      super.paintComponent(g);

      int width = getWidth();
      int height = getHeight();

      // initialize these guys each time paintComponent is called
      int x1 = GAP;
      int y1 = height / 2;
      int x2 = width - 2 * GAP;
      int y2 = y1;
      g.drawLine(x1, y1, x2, y2);

      for (int i = START; i <= END; i++) {
         int x = (i * (x2 - x1)) / (END - START) + GAP;
         drawNumberAndLine(g, i, x, y1, VERT_LINE_HEIGHT);
      }
   }

   private void drawNumberAndLine(Graphics g, int number, int x, int y,
         int vertLineHeight) {
      int x1 = x;
      int y1 = y;
      int x2 = x;
      int y2 = y - vertLineHeight;
      g.drawLine(x1, y1, x2, y2);

      String text = String.valueOf(number);
      g.setFont(FONT);
      FontMetrics fontMetrics = g.getFontMetrics();
      int textX = x - fontMetrics.stringWidth(text) / 2;
      int textY = y + fontMetrics.getHeight() + TEXT_GAP;
      g.drawString(text, textX, textY);
   }

   @Override // make GUI bigger
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Number Line");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new SimpleNumberLinePanel());
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