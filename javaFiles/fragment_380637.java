import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class SeveralButtons extends JPanel {
   // preferred size dimensions
   private static final int PREF_W = 450;
   private static final int PREF_H = 300;

   // number of buttons displayed
   private static final int BUTTON_COUNT = 4;
   public static final String BLANK_PANEL = "blank";
   public static final String MAIN_PANEL = "main panel";
   private CardLayout cardLayout = new CardLayout();

   public SeveralButtons() {
      // create JPanel to hold our buttons. use a grid layout with 1 column
      JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 5, 5));
      for (int i = 0; i < BUTTON_COUNT; i++) {
          // create a new JButton and give it a an Action
         JButton button = new JButton(new ButtonAction(i));
         // add it to the buttonPanel
         buttonPanel.add(button);
      }

      // main JPanel to hold the buttonPanel
      JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
      mainPanel.add(buttonPanel);

      // set this class's layout
      setLayout(cardLayout);
      add(mainPanel, MAIN_PANEL); // add mainPanel
      add(new JPanel(), BLANK_PANEL);  // add a blank JPanel
   }

   @Override // so JPanel will be at least our desired size
   public Dimension getPreferredSize() {
      Dimension superSz = super.getPreferredSize();
      if (isPreferredSizeSet()) {
         return superSz;
      }
      int prefW = Math.max(superSz.width, PREF_W);
      int prefH = Math.max(superSz.height, PREF_H);
      return new Dimension(prefW, prefH);
   }

   // our AbstractAction class, an ActionListener "on steroids"
   private class ButtonAction extends AbstractAction {
      private int value;

      public ButtonAction(int i) {
         String name = "Button " + i;
         putValue(NAME, name);
         this.value = i;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO: do some number specific action based on value
         // For a trivial example:
         String message = "Button pressed: " + value;
         JOptionPane.showMessageDialog((Component) e.getSource(), message);

         // swap view to a blank view
         cardLayout.show(SeveralButtons.this, BLANK_PANEL);
      }
   }

   // create and display GUI in a thread-safe manner
   private static void createAndShowGui() {
      SeveralButtons mainPanel = new SeveralButtons();

      JFrame frame = new JFrame("SeveralButtons");
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