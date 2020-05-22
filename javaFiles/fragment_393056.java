import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemo2 {
   private static final String[] TOGGLE_NAMES = { "Monday", "Tuesday",
         "Wednesday" };
   private JPanel mainPanel = new JPanel();
   private JButton leftButton = new JButton("Left");
   private JButton rightButton = new JButton("Right");

   private JToggleButton[] toggleBtns = new JToggleButton[TOGGLE_NAMES.length];

   public JButtonDemo2() {
      JPanel topPanel = new JPanel();
      topPanel.add(leftButton);
      topPanel.add(rightButton);
      leftButton.setEnabled(false);
      rightButton.setEnabled(false);

      CheckListener checkListener = new CheckListener();
      JPanel bottomPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      for (int i = 0; i < toggleBtns.length; i++) {

         // uncomment one of the lines below to see the program 
         // with check boxes vs. radio buttons, vs toggle buttons
         toggleBtns[i] = new JCheckBox(TOGGLE_NAMES[i]);
         // toggleBtns[i] = new JRadioButton(TOGGLE_NAMES[i]);
         // toggleBtns[i] = new JToggleButton(TOGGLE_NAMES[i]);


         toggleBtns[i].setActionCommand(TOGGLE_NAMES[i]);
         toggleBtns[i].addActionListener(checkListener);
         bottomPanel.add(toggleBtns[i]);
      }

      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
      mainPanel.add(topPanel);
      mainPanel.add(bottomPanel);
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

   public void enableTopButtons(boolean enable) {
      leftButton.setEnabled(enable);
      rightButton.setEnabled(enable);
   }

   private class CheckListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         for (JToggleButton checkBox : toggleBtns) {
            if (checkBox.isSelected()) {
               enableTopButtons(true);
               return;
            }
         }
         enableTopButtons(false);
      }

   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("JButtonDemo2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new JButtonDemo2().getMainComponent());
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