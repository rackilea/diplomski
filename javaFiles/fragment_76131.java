import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;

class Foo {

   public Foo() {
       JButton button = new JButton(new ButtonAction("Action", KeyEvent.VK_A));
   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction(String name, Integer mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         System.out.println("button pressed");
      }
   }

}