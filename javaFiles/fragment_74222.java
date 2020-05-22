import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class ContentPane extends JPanel {

   public static final String MENU = "menu";
   public static final String GAME = "game";
   private static final int PREF_W = 640;
   private static final int PREF_H = 480;

   private CardLayout cardlayout = new CardLayout();
   private JPanel menu = new JPanel();
   private JButton start;
   private Zeichnen game;

   public ContentPane() {
      setLayout(cardlayout);
      start = new JButton("Start Game");
      game = new Zeichnen();

      add(menu, MENU);
      add(game, GAME);

      start.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            cardlayout.next(ContentPane.this);
         }
      });

      menu.add(start);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Epic Game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new ContentPane());
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