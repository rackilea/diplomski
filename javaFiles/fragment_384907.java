import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MainGui2 extends JPanel {
   private static final int TAB_COUNT = 3;
   private JTabbedPane tabbedPane = new JTabbedPane();
   private PlainDocument doc = new PlainDocument();
   private Action btnAction = new ButtonAction("Button");

   public MainGui2() {
      for (int i = 0; i < TAB_COUNT; i++) {
         tabbedPane.add("Tab " + (i + 1), createPanel(doc, btnAction));
      }
      setLayout(new BorderLayout());
      add(tabbedPane);
   }

   private JPanel createPanel(PlainDocument doc, Action action) {
      JTextArea textArea = new JTextArea(doc);
      textArea.setColumns(40);
      textArea.setRows(20);          

      JPanel panel = new JPanel();
      panel.add(new JScrollPane(textArea));
      panel.add(new JButton(action));
      return panel;
   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction(String title) {
         super(title);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         try {
            String text = "Button Pressed!\n";
            doc.insertString(doc.getLength(), text, null);
         } catch (BadLocationException e) {
            e.printStackTrace();
         }
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("MainGui2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new MainGui2());
      frame.pack();
      frame.setLocationRelativeTo(null);
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