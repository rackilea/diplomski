import java.awt.event.*;
import javax.swing.*;

public class KeyBindingsEg {
   private static void createAndShowGui() {
      PanelContainer mainPanel = new PanelContainer();

      JFrame frame = new JFrame("KeyBindingsEg");
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

@SuppressWarnings("serial")
class PanelContainer extends JPanel {

   public PanelContainer() {
      this.setFocusable(true);
      this.addKeyListener(new MyKeyListener());
      JButton newGameButton = new JButton("New Game");
      newGameButton.addActionListener(new MyActionListener());
      add(newGameButton);
      setKeyBindings();
   }

   private void setKeyBindings() {
      Action hideAction = new BindingAction(BindingAction.HIDE);
      Action showAction = new BindingAction(BindingAction.SHOW);
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      actionMap.put(BindingAction.HIDE, hideAction);
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_H, 0), BindingAction.HIDE);
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.SHIFT_DOWN_MASK),
            BindingAction.HIDE);

      int[] showKeys = { KeyEvent.VK_O, KeyEvent.VK_ESCAPE };
      actionMap.put(BindingAction.SHOW, showAction);
      for (int key : showKeys) {
         inputMap.put(KeyStroke.getKeyStroke(key, 0), BindingAction.SHOW);
         inputMap.put(KeyStroke.getKeyStroke(key, KeyEvent.SHIFT_DOWN_MASK),
               BindingAction.SHOW);
      }

   }

   private class MyActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent aevt) {
         System.out.println("button pressed");
      }
   }

   private class MyKeyListener extends KeyAdapter {
      public void keyReleased(KeyEvent kevt) {
         if (kevt.getKeyCode() == KeyEvent.VK_ESCAPE
               || kevt.getKeyChar() == 'O' || kevt.getKeyChar() == 'o') {
            System.out.println("KeyListener: show");
         } else if (kevt.getKeyChar() == 'h' || kevt.getKeyChar() == 'H') {
            System.out.println("KeyListener: hide");
         }
      }
   }

   private class BindingAction extends AbstractAction {
      public static final String HIDE = "Hide";
      public static final String SHOW = "Show";

      public BindingAction(String text) {
         super(text);
         putValue(ACTION_COMMAND_KEY, text);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         String actionCommand = evt.getActionCommand();
         if (actionCommand.equals(HIDE)) {
            System.out.println("key bindings: hide");
         } else if (actionCommand.equals(SHOW)) {
            System.out.println("key bindings: show");
         }
      }
   }
}