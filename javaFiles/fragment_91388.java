import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class EnforceSizeTest extends JPanel {
   private static final int MAX_LENGTH = 256;
   private JTextArea textArea = new JTextArea(15, 20);

   public EnforceSizeTest() {
      textArea.setWrapStyleWord(true);
      textArea.setLineWrap(true);
      ((PlainDocument) textArea.getDocument()).setDocumentFilter(new MyDocumentFilter(MAX_LENGTH));

      add(new JScrollPane(textArea));
   }

   private class MyDocumentFilter extends DocumentFilter {
      private static final int MAX_LENGTH = 256;
      private int maxLength;

      public MyDocumentFilter(int maxLength) {
         this.maxLength = maxLength;
      }

      @Override
      public void insertString(FilterBypass fb, int offset, String string,
            AttributeSet attr) throws BadLocationException {
         Document doc = fb.getDocument();
         StringBuilder sb = new StringBuilder();
         sb.append(doc.getText(0, doc.getLength()));
         sb.insert(offset, string);
         if (sb.length() > maxLength) {
            return;
         }
         super.insertString(fb, offset, string, attr);
      }

      @Override
      public void replace(FilterBypass fb, int offset, int length, String text,
            AttributeSet attrs) throws BadLocationException {
         Document doc = fb.getDocument();
         StringBuilder sb = new StringBuilder();
         sb.append(doc.getText(0, doc.getLength()));
         sb.replace(offset, offset + length, text);
         if (sb.length() > MAX_LENGTH) {
            return;
         }
         super.replace(fb, offset, length, text, attrs);
      }
   }

   private static void createAndShowGui() {
      EnforceSizeTest mainPanel = new EnforceSizeTest();

      JFrame frame = new JFrame("EnforceSizeTest");
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