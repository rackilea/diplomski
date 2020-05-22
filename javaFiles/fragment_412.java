import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VaryingTextFieldSize {
   protected static final int GAP = 5;

   public static void main(String[] args) {
      final JTextField textField = new JTextField(1) {
         @Override
         public Dimension getPreferredSize() {
            Dimension superPref = super.getPreferredSize();
            FontMetrics fontMetrics = getFontMetrics(getFont());
            String text = getText();
            if (text.length() > 0) {
               int width = fontMetrics.charsWidth(text.toCharArray(), 0, text.length()) + GAP;
               return new Dimension(width, superPref.height);
            }
            return superPref;
         }
      };
      textField.getDocument().addDocumentListener(new DocumentListener() {
         @Override
         public void removeUpdate(DocumentEvent e) {
            reSize();
         }

         @Override
         public void insertUpdate(DocumentEvent e) {
            reSize();
         }

         @Override
         public void changedUpdate(DocumentEvent e) {
            reSize();
         }

         private void reSize() {
            SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                  Container container = textField.getParent();
                  container.revalidate();
                  container.repaint();
               }
            });
         }
      });
      JPanel enclosingPanel = new JPanel();
      enclosingPanel.setPreferredSize(new Dimension(300, 100));
      enclosingPanel.add(textField);
      JOptionPane.showMessageDialog(null, enclosingPanel);
   }
}