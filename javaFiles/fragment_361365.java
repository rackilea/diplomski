import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutTestPanel extends JPanel {
   public static final String CARD_JBUTTON = "Card JButton";
   public static final String CARD_JTEXTFIELD = "Card JTextField";
   public static final String CARD_JRADIOBUTTON = "Card JRadioButton";

   private static void createAndShowGui() {
      final CardLayoutTestPanel cardLayoutTestPanel = new CardLayoutTestPanel();

      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
      buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      final JButton previousButton = new JButton("PREVIOUS");
      previousButton.setBackground(Color.BLACK);
      previousButton.setForeground(Color.WHITE);
      final JButton nextButton = new JButton("NEXT");
      nextButton.setBackground(Color.RED);
      nextButton.setForeground(Color.WHITE);
      buttonPanel.add(previousButton);
      buttonPanel.add(nextButton);

      previousButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            cardLayoutTestPanel.previousCard();
         }
      });
      nextButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            cardLayoutTestPanel.nextCard();
         }
      });

      JFrame frame = new JFrame("CardLayoutTest");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(cardLayoutTestPanel);
      frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
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

   private CardLayout cardLayout = new CardLayout(20, 20);
   private JPanel cardShowingPanel = new JPanel(cardLayout);

   public CardLayoutTestPanel() {
      /*
       * Here we be making objects of the Window Series classes so that, each
       * one of them can be added to the JPanel having CardLayout.
       */
      Window1 win1 = new Window1();
      cardShowingPanel.add(win1, CARD_JBUTTON);
      Window2 win2 = new Window2();
      cardShowingPanel.add(win2, CARD_JTEXTFIELD);
      Window3 win3 = new Window3();
      cardShowingPanel.add(win3, CARD_JRADIOBUTTON);

      setLayout(new BorderLayout());

      // Adding the contentPane (JPanel) and buttonPanel to JFrame.
      add(cardShowingPanel, BorderLayout.CENTER);
   }

   public void nextCard() {
      cardLayout.next(cardShowingPanel);
   }

   public void previousCard() {
      cardLayout.previous(cardShowingPanel);
   }

   public void showCard(String key) {
      cardLayout.show(cardShowingPanel, key);
   }

}

class Window1 extends JPanel {
   /*
    * Here this is our first Card of CardLayout, which will be added to the
    * contentPane object of JPanel, which has the LayoutManager set to
    * CardLayout. This card consists of Two JButtons.
    */
   private ActionListener action;

   public Window1() {
      init();
   }

   private void init() {
      final JButton clickButton = new JButton("CLICK ME");
      final JButton dontClickButton = new JButton("DON\'T CLICK ME");

      action = new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == clickButton) {
               JOptionPane.showMessageDialog(null, "Hello there dude!",
                     "Right Button", JOptionPane.INFORMATION_MESSAGE);
            } else if (ae.getSource() == dontClickButton) {
               JOptionPane.showMessageDialog(null,
                     "I told you not to click me!", "Wrong Button",
                     JOptionPane.PLAIN_MESSAGE);
            }
         }
      };

      clickButton.addActionListener(action);
      dontClickButton.addActionListener(action);

      add(clickButton);
      add(dontClickButton);
   }
}

class Window2 extends JPanel implements ActionListener {
   /*
    * Here this is our second Card of CardLayout, which will be added to the
    * contentPane object of JPanel, which has the LayoutManager set to
    * CardLayout. This card consists of a JLabel and a JTextField with
    * GridLayout.
    */

   private JTextField textField;

   public Window2() {
      init();
   }

   private void init() {
      setLayout(new GridLayout(1, 2));
      JLabel userLabel = new JLabel("Your Name : ");
      textField = new JTextField();
      textField.addActionListener(this);

      add(userLabel);
      add(textField);
   }

   public void actionPerformed(ActionEvent e) {
      if (textField.getDocument().getLength() > 0)
         JOptionPane.showMessageDialog(null,
               "Your Name is : " + textField.getText(), "User\'s Name : ",
               JOptionPane.QUESTION_MESSAGE);
   }
}

class Window3 extends JPanel {
   /*
    * Here this is our third Card of CardLayout, which will be added to the
    * contentPane object of JPanel, which has the LayoutManager set to
    * CardLayout. This card consists of Two JLabels and two JCheckBox with
    * GridLayout.
    */
   private ActionListener state;

   public Window3() {
      init();
   }

   public void init() {
      setLayout(new GridLayout(2, 2));
      JLabel maleLabel = new JLabel("MALE", JLabel.CENTER);
      final JCheckBox maleBox = new JCheckBox();
      JLabel femaleLabel = new JLabel("FEMALE", JLabel.CENTER);
      final JCheckBox femaleBox = new JCheckBox();

      state = new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            if (maleBox == (JCheckBox) ae.getSource()) {
               femaleBox.setSelected(false);
               JOptionPane.showMessageDialog(null, "Congrats you are a Male",
                     "Gender : ", JOptionPane.INFORMATION_MESSAGE);
            } else if (femaleBox == (JCheckBox) ae.getSource()) {
               maleBox.setSelected(false);
               JOptionPane.showMessageDialog(null, "Congrats you are a Female",
                     "Gender : ", JOptionPane.INFORMATION_MESSAGE);
            }
         }
      };

      maleBox.addActionListener(state);
      femaleBox.addActionListener(state);
      add(maleLabel);
      add(maleBox);
      add(femaleLabel);
      add(femaleBox);
   }
}