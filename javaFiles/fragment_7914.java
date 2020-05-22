import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;    
import javax.swing.*;

public class JDialogTest {
   private static void createAndShowGUI() {
      final JFrame frame = new JFrame("JDialogTest");

      JPanel panel = new JPanel();
      panel.add(new JButton(new AbstractAction("Push Me") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            final JTextArea textArea = new JTextArea(15, 30);
            textArea.setFocusable(false);
            JDialog dialog = new JDialog(frame, "Dialog", true);

            int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
            JPanel contentPane = (JPanel) dialog.getContentPane();
            InputMap inputMap = contentPane.getInputMap(condition);
            ActionMap actionMap = contentPane.getActionMap();

            KeyStroke enterKs = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
            inputMap.put(enterKs, enterKs.toString());
            actionMap.put(enterKs.toString(), new AbstractAction() {

               @Override
               public void actionPerformed(ActionEvent arg0) {
                  textArea.append("Enter pushed\n");
               }
            });

            KeyStroke escKs = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
            inputMap.put(escKs, escKs.toString());
            actionMap.put(escKs.toString(), new AbstractAction() {

               @Override
               public void actionPerformed(ActionEvent arg0) {
                  textArea.append("Escape pushed\n");
               }
            });


            dialog.add(new JScrollPane(textArea));
            dialog.pack();
            dialog.setVisible(true);
         }
      }));

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}