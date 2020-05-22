import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class CardLayoutEg extends JPanel {
   private static final String[] CARD_LABELS = { "one", "two", "three", "four",
         "five", "six", "seven", "eight", "nine", "ten" };
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private CardLayout cardlayout = new CardLayout();
   private JPanel cardHolder = new JPanel(cardlayout);
   private Action[] actions = { new ShowPreviousAction(), new ShowNextAction(),
         new ShowTwoCardAction() };

   public CardLayoutEg() {
      for (String cardLabelText : CARD_LABELS) {
         JLabel cardLabel = new JLabel(cardLabelText, SwingConstants.CENTER);
         cardHolder.add(cardLabel, cardLabelText);
      }

      JPanel btnPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      for (Action action : actions) {
         btnPanel.add(new JButton(action));
      }

      setLayout(new BorderLayout());
      add(cardHolder, BorderLayout.CENTER);
      add(btnPanel, BorderLayout.SOUTH);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class ShowPreviousAction extends AbstractAction {
      public ShowPreviousAction() {
         super("Previous");
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         cardlayout.previous(cardHolder);
      }
   }

   private class ShowNextAction extends AbstractAction {
      public ShowNextAction() {
         super("Next");
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         cardlayout.next(cardHolder);
      }
   }

   private class ShowTwoCardAction extends AbstractAction {
      public ShowTwoCardAction() {
         super("Show Two");
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         cardlayout.show(cardHolder, CARD_LABELS[1]);
      }
   }

   private static void createAndShowGui() {
      CardLayoutEg mainPanel = new CardLayoutEg();

      JFrame frame = new JFrame("CardLayout Example");
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