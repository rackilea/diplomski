import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedListener {
   private static void createAndShowUI() {
      final JTabbedPane tabbedPane = new JTabbedPane();
      for (int i = 0; i < 5; i++) {
         tabbedPane.add("Tab " + i, new JLabel("Label " + i, SwingConstants.CENTER));
      }

      tabbedPane.getModel().addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            JLabel label = (JLabel) tabbedPane.getSelectedComponent();
            System.out.println(label.getText());
         }
      });

      tabbedPane.setPreferredSize(new Dimension(500, 300));

      JFrame frame = new JFrame("TabbedListener");
      frame.getContentPane().add(tabbedPane);
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