import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class BackgroundColorChange extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final int TIMER_DELAY = 75;

   public BackgroundColorChange() {
      new Timer(TIMER_DELAY, new ActionListener() {
         private int c = 1;

         @Override
         public void actionPerformed(ActionEvent arg0) {
            setBackground(Color.getHSBColor((float) c / 360, 1f, 1f));
            repaint();
            c = (c >= 360) ? 1 : c + 5;
         }
      }).start();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      BackgroundColorChange mainPanel = new BackgroundColorChange();

      JFrame frame = new JFrame("BackgroundColorChange");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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