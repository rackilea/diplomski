import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class TextAreaFun extends JPanel {
   public static final String SPACE = "space";
   public static final String BACK_SPACE = "back space";
   private JTextArea textArea = new JTextArea(15, 50);

   public TextAreaFun() {
      // create our key bindings
      // only allow key presses to initiate an action if the JTextArea has focus
      int condition = JComponent.WHEN_FOCUSED;
      InputMap taInputMap = textArea.getInputMap(condition);
      ActionMap taActionMap = textArea.getActionMap();

      taInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), SPACE);
      taInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0),
            BACK_SPACE);
      taActionMap.put(SPACE, new KeyAction(textArea, SPACE));
      taActionMap.put(BACK_SPACE, new KeyAction(textArea, BACK_SPACE));

      // checkbox that stops all editing except for that specified in the 
      // key bindings above
      JCheckBox chkBox = new JCheckBox(new AbstractAction("Prevent Editing") {
         {
            putValue(SELECTED_KEY, Boolean.FALSE); // default to unchecked
            putValue(MNEMONIC_KEY, KeyEvent.VK_P);
         }

         @Override
         public void actionPerformed(ActionEvent evt) {
            boolean selection = (Boolean) getValue(SELECTED_KEY);
            textArea.setEditable(!selection);
         }
      });
      JPanel bottomPanel = new JPanel();
      bottomPanel.add(chkBox);

      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      add(new JScrollPane(textArea));
      add(Box.createVerticalStrut(10));
      add(bottomPanel);
   }

   private static void createAndShowGui() {
      TextAreaFun mainPanel = new TextAreaFun();

      JFrame frame = new JFrame("TextAreaFun");
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
// action to be initiated by key bindings
class KeyAction extends AbstractAction {
   private PlainDocument textAreaDocument;
   private String title;

   public KeyAction(JTextArea textArea, String title) {
      this.textAreaDocument = (PlainDocument) textArea.getDocument();
      this.title = title;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (title.equals(TextAreaFun.SPACE)) {
         try {
            textAreaDocument.insertString(textAreaDocument.getLength(), " ",
                  null);
         } catch (BadLocationException e1) {
            e1.printStackTrace();
         }
      } else if (title.equals(TextAreaFun.BACK_SPACE)) {
         if (textAreaDocument.getLength() == 0) {
            return;
         }
         try {
            textAreaDocument.remove(textAreaDocument.getLength() - 1, 1);
         } catch (BadLocationException e1) {
            e1.printStackTrace();
         }
      }
   }
}