import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class TheDungeon2 extends JPanel {
   private static final int PREF_W = 750;
   private static final int PREF_H = 600;
   private static final String[] BUTTON_LABELS = {"Button 1", "Button 2", 
         "Button 3", "Button 4", "Button 5"};
   private static final String WELCOME_TEXT = "Welcome %s to the game that has no name!";

   private JLabel welcomeLabel = new JLabel("", SwingConstants.CENTER);
   private String name;   

   public TheDungeon2() {
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      for (String buttonLabel : BUTTON_LABELS) {
         JButton button = new JButton(buttonLabel);
         buttonPanel.add(button);
      }

      setLayout(new BorderLayout());
      add(welcomeLabel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.PAGE_END);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public void getAndSetName() {
      name = JOptionPane.showInputDialog(this, "What will your name be?");
      welcomeLabel.setText(String.format(WELCOME_TEXT, name));
   }

   private static void createAndShowGui() {
      TheDungeon2 dungeon2 = new TheDungeon2();

      JFrame frame = new JFrame("Nameless Game");

      dungeon2.getAndSetName();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(dungeon2);
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