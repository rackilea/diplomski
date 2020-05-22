import java.awt.*;
import javax.swing.*;

public class SwingExample extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = 300;

   public SwingExample() {
      setBackground(Color.black); //Sets the background to black.
      Font myFont = new Font("Arial", Font.PLAIN, 14); //Makes "myFont" a font that is plain.
      setFont(myFont); //Sets the font to "myFont"..
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.blue); //Sets anything in "paint" to be in blue.
      int xArray[] = {20, 110, 200, 200, 110, 20, 20}; //This line, and the line below are the cords for the bowtie.
      int yArray[] = {20, 45, 20, 100, 65, 100, 20};
      g.drawPolygon(xArray, yArray, 7); //Draws the bowtie.
      g.drawString("Bow ties are no longer cool.", 20, 150); //Writes the text.
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      SwingExample mainPanel = new SwingExample();

      JFrame frame = new JFrame("SwingExample");
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