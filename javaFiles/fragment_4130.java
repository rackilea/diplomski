import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Foo003 {
   private static final String ENTER = "enter";

   public static void main(String[] args) {
      final JTextArea myArea = new JTextArea(10, 20);
      final PlainDocument myDocument = (PlainDocument) myArea.getDocument();

      DocumentListener myDocumentListener = new DocumentListener() {
         private boolean changing = false;

         public void removeUpdate(DocumentEvent e) {}

         public void changedUpdate(DocumentEvent e) {
            toUpperCase(myArea, myDocument);
         }

         @Override
         public void insertUpdate(DocumentEvent e) {
            toUpperCase(myArea, myDocument);
         }

         private void toUpperCase(final JTextArea myArea,
               final PlainDocument myDocument) {
            if (changing) {
               return;
            }
            try {
               changing = true;
               final String text = myDocument
                     .getText(0, myDocument.getLength()).toUpperCase();
               SwingUtilities.invokeLater(new Runnable() {
                  public void run() {
                     myArea.setText(text);
                     changing = false;
                  }
               });
            } catch (BadLocationException e1) {
               e1.printStackTrace();
            }
         }

      };

      myDocument.addDocumentListener(myDocumentListener);

      JOptionPane.showMessageDialog(null, new JScrollPane(myArea),
            "With DocumentListener", JOptionPane.INFORMATION_MESSAGE);

      myDocument.removeDocumentListener(myDocumentListener);

      myArea.setText("");

      myDocument.setDocumentFilter(new DocumentFilter() {
         @Override
         public void insertString(FilterBypass fb, int offset, String text,
               AttributeSet attr) throws BadLocationException {
            text = text.toUpperCase();
            super.insertString(fb, offset, text, attr);
         }

         @Override
         public void replace(FilterBypass fb, int offset, int length,
               String text, AttributeSet attrs) throws BadLocationException {
            text = text.toUpperCase();
            super.replace(fb, offset, length, text, attrs);
         }
      });
      JOptionPane.showMessageDialog(null, new JScrollPane(myArea),
            "With DocumentFilter", JOptionPane.INFORMATION_MESSAGE);
   }
}