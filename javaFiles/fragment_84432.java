import java.awt.event.*;
import javax.swing.*;

public class TestBoundAbstractActions {
   public static void main(String[] args) {
      final MyAction myAction = new MyAction();
      final JButton actionButton = new JButton(myAction);

      JRadioButton enableRadioButton = new JRadioButton("Enabled", true);
      enableRadioButton.addItemListener(new ItemListener() {

         @Override
         public void itemStateChanged(ItemEvent e) {
            myAction.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
         }
      });


      JPanel panel = new JPanel();

      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      String mKey = "m key";
      panel.getInputMap(condition).put(KeyStroke.getKeyStroke(KeyEvent.VK_M, 0), mKey);
      panel.getActionMap().put(mKey, myAction);

      panel.add(new JLabel("Press \"m\" to activate key-bound action"));          
      panel.add(actionButton);
      panel.add(enableRadioButton);

      JOptionPane.showMessageDialog(null, panel);
   }
}

class MyAction extends AbstractAction {
   public MyAction() {
      super("My Action");
      putValue(MNEMONIC_KEY, KeyEvent.VK_M);
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      System.out.println("boo!");
   }
}