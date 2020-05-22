import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class DocListenerProblem extends JPanel {
   private static final String REPLACE_CHARS = "0123456789.";
   private JTextField txtName = new JTextField(20);

   public DocListenerProblem() {
      add(txtName);
      PlainDocument doc = (PlainDocument) txtName.getDocument();
      doc.setDocumentFilter(new MyDocumentFilter());
   }

   private class MyDocumentFilter extends DocumentFilter {

      @Override
      public void insertString(FilterBypass fb, int offset, String text,
               AttributeSet attr) throws BadLocationException {
         if (REPLACE_CHARS.contains(text)) {
            text = doSwap(text);
         }
         super.insertString(fb, offset, text, attr);
      }

      @Override
      public void replace(FilterBypass fb, int offset, int length, String text,
               AttributeSet attrs) throws BadLocationException {
         if (REPLACE_CHARS.contains(text)) {
            text = doSwap(text);
         }
         super.replace(fb, offset, length, text, attrs);
      }

      @Override
      public void remove(FilterBypass fb, int offset, int length)
               throws BadLocationException {
         super.remove(fb, offset, length);
      }
   }

   public String doSwap(String text) {
      StringBuilder sb = new StringBuilder();
      for (char c : text.toCharArray()) {
         if (REPLACE_CHARS.contains(String.valueOf(c))) {
            if (c == '.') {
               c = ',';
            } else {
               c = (char) ('\u0660' - '0' + c);
            }
         }
         sb.append(c);
      }
      return sb.toString();
   }

   private static void createAndShowUI() {

      JFrame frame = new JFrame("DocListenerProblem");
      frame.getContentPane().add(new DocListenerProblem());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }

}