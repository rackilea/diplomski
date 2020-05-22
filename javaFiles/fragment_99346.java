import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class ShowMyDialogTest {

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Show MyDialog Test");

      JPanel mainPanel = new JPanel();
      Action showAction = new ShowDialogAction(frame, "Show Dialog");
      final JButton showDialogBtn = new JButton(showAction);
      mainPanel.add(showDialogBtn);
      mainPanel.setPreferredSize(new Dimension(600, 400));

      KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = showDialogBtn.getInputMap(condition);
      ActionMap actionMap = showDialogBtn.getActionMap();
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new AbstractAction() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            showDialogBtn.doClick();
         }
      });

      JMenuItem showMenuItem = new JMenuItem(showAction);
      JMenuItem exitMenuItem = new JMenuItem(new DisposeAction("Exit", KeyEvent.VK_X));
      JMenu fileMenu = new JMenu("File"); 
      fileMenu.setMnemonic(KeyEvent.VK_F);
      fileMenu.add(showMenuItem);
      fileMenu.add(exitMenuItem);

      JMenuBar menuBar = new JMenuBar();
      menuBar.add(fileMenu);
      frame.setJMenuBar(menuBar);      

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

class ShowDialogAction extends AbstractAction {
   private JFrame frame;
   private ShowDialogPanel dialogPanel;
   private JDialog dialog;

   public ShowDialogAction(JFrame frame, String name) {
      super(name);
      int mnemonic = (int) name.charAt(0);
      putValue(MNEMONIC_KEY, mnemonic);
      this.frame = frame;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (dialogPanel == null) {
         dialogPanel = new ShowDialogPanel();
      }
      if (dialog == null) {
         dialog = new JDialog(frame, "My Dialog", ModalityType.APPLICATION_MODAL);
         dialog.getContentPane().add(dialogPanel);
         dialog.pack();
      }
      dialog.setLocationRelativeTo(frame);
      dialog.setVisible(true);
      // TODO add any code that extracts data from dialogPanel

   }
}

class ShowDialogPanel extends JPanel {
   private JButton button = new JButton(new DisposeAction("Close", KeyEvent.VK_C));

   public ShowDialogPanel() {
      add(button);
   }
}

class DisposeAction extends AbstractAction {
   private static final long serialVersionUID = 1L;

   public DisposeAction(String name, int mnemonic) {
      super(name);
      putValue(MNEMONIC_KEY, mnemonic);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Component component = (Component) e.getSource();
      Window win = SwingUtilities.getWindowAncestor(component);
      if (win == null) {
         JPopupMenu popup = (JPopupMenu) component.getParent();
         if (popup == null) {
            return;
         }
         component = popup.getInvoker();
         win = SwingUtilities.getWindowAncestor(component);
      }
      win.dispose();
   }
}