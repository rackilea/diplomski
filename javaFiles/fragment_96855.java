import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class DisbleButton extends JPanel {
   private JTextField field = new JTextField(10);
   private ButtonAction buttonAction = new ButtonAction();
   private JButton button = new JButton(buttonAction);

   public DisbleButton() {
      add(field);
      add(button);
      buttonAction.setEnabled(false);

      field.getDocument().addDocumentListener(new FieldDocListener());
   }

   private class FieldDocListener implements DocumentListener {

      @Override
      public void changedUpdate(DocumentEvent dEvt) {
         testDoc(dEvt);
      }

      @Override
      public void insertUpdate(DocumentEvent dEvt) {
         testDoc(dEvt);
      }

      @Override
      public void removeUpdate(DocumentEvent dEvt) {
         testDoc(dEvt);
      }

      private void testDoc(DocumentEvent dEvt) {
         Document doc = dEvt.getDocument();
         buttonAction.setEnabled(doc.getLength() > 0);
      }

   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction() {
         super("Press Me");
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO do calculation here!

      }
   }

   private static void createAndShowGui() {
      DisbleButton mainPanel = new DisbleButton();

      JFrame frame = new JFrame("DisbleButton");
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