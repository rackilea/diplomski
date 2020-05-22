import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DocListenerEg extends JPanel {
   private static final int FIELD_COUNT = 10;
   private static final int COLUMNS = 8;
   private JButton saveButton = new JButton(new SaveAction("Save", KeyEvent.VK_S));
   private List<JTextField> fieldList = new ArrayList<>();

   public DocListenerEg() {
      MyDocListener docListener = new MyDocListener();
      add(saveButton);
      for (int i = 0; i < FIELD_COUNT; i++) {
         JTextField field = new JTextField(COLUMNS);
         add(field);
         fieldList.add(field);

         field.getDocument().addDocumentListener(docListener);
      }
   }

   public void documentChange() {
      saveButton.setEnabled(true);
   }

   private class MyDocListener implements DocumentListener {
      private boolean changed = false;

      @Override
      public void changedUpdate(DocumentEvent dEvt) {
         documentChange();
      }

      @Override
      public void insertUpdate(DocumentEvent dEvt) {
         documentChange();
      }

      @Override
      public void removeUpdate(DocumentEvent dEvt) {
         documentChange();
      }

   }

   private class SaveAction extends AbstractAction {

      public SaveAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         // TODO: save the data
         ((AbstractButton) evt.getSource()).setEnabled(false);
      }

   }

   private static void createAndShowGui() {
      DocListenerEg mainPanel = new DocListenerEg();

      JFrame frame = new JFrame("DocListenerEg");
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