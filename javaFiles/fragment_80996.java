import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.*;

public class DocFilterPanel extends JPanel {
   private JTextArea textArea = new JTextArea(12, 50);
   private MyDocFilter myDocFilter = new MyDocFilter();

   public DocFilterPanel() {
      ((PlainDocument) textArea.getDocument()).setDocumentFilter(myDocFilter);
      int vsbPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
      int hsbPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED;
      add(new JScrollPane(textArea, vsbPolicy , hsbPolicy));

      int timerDelay = 1000;
      new Timer(timerDelay , new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            myDocFilter.setFilter(false);
            textArea.append("12345\n");
            myDocFilter.setFilter(true);
         }
      }).start();
   }

   private static void createAndShowGui() {
      DocFilterPanel docFilterPanel = new DocFilterPanel();

      JFrame frame = new JFrame("DocFilterTest");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(docFilterPanel);
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

class MyDocFilter extends DocumentFilter {
   private static final String REMOVE_REGEX = "\\d";
   private boolean filter = true;

   public boolean isFilter() {
      return filter;
   }

   public void setFilter(boolean filter) {
      this.filter = filter;
   }

   @Override
   public void insertString(FilterBypass fb, int offset, String text,
         AttributeSet attr) throws BadLocationException {
      if (filter) {
         text = text.replaceAll(REMOVE_REGEX, "");
      }
      super.insertString(fb, offset, text, attr);

   }

   @Override
   public void replace(FilterBypass fb, int offset, int length, String text,
         AttributeSet attrs) throws BadLocationException {
      if (filter) {
         text = text.replaceAll(REMOVE_REGEX, "");
      }
      super.replace(fb, offset, length, text, attrs);

   }
}