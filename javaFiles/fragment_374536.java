import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Main {
   private static JPanel mainPanel = new JPanel();
   private static JFrame frame;
   public static JTextField textField1 = new JTextField(20);
   public static JTextField textField2 = new JTextField(20);

   public static void main(String[] Args) throws InterruptedException {
      frame = new JFrame("Test Window");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      final JCheckBox dispatchKeyEventReturnCheckBox = 
            new JCheckBox("Dispatch Key Event Return Value", true);

      mainPanel.add(textField1);
      mainPanel.add(textField2);
      mainPanel.add(dispatchKeyEventReturnCheckBox);
      frame.add(mainPanel);

      KeyboardFocusManager.getCurrentKeyboardFocusManager()
            .addKeyEventDispatcher(new KeyEventDispatcher() {

               @Override
               public boolean dispatchKeyEvent(KeyEvent evt) {
                  // TODO Fix this!!!
                  // !! return false;
                  return dispatchKeyEventReturnCheckBox.isSelected();
               }
            });

      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      textField1.setText("I am a simple uneditable testbox");
   }
}