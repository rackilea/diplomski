import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class SwapPanels extends JPanel {
   public static final String INTRO_PANEL = "intro panel";
   public static final String QUESTION_PANEL = "question panel";
   private static final int PREF_W = 500;
   private static final int PREF_H = 400;
   private CardLayout cardLayout = new CardLayout();
   private JPanel introPanel;
   private JPanel questionPanel;
   private Random random = new Random();

   public SwapPanels() {
      introPanel = createPanel("Introduction");
      questionPanel = createPanel("Question");
      setLayout(cardLayout);
      add(introPanel, INTRO_PANEL);
      add(questionPanel, QUESTION_PANEL);

      int delay = 3 * 1000; // show intro for 3 seconds
      new Timer(delay, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            cardLayout.show(SwapPanels.this, QUESTION_PANEL);
            ((Timer) e.getSource()).stop();
         }
      }).start();
   }

   private JPanel createPanel(String title) {
      int rgb = random.nextInt();
      Color color = new Color(rgb);
      JPanel panel = new JPanel(new GridBagLayout());
      panel.setBorder(BorderFactory.createLineBorder(color, 60));
      panel.add(new JLabel(title));
      return panel;
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      SwapPanels mainPanel = new SwapPanels();

      JFrame frame = new JFrame("SwapPanels");
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