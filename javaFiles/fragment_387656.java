import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TableAndButton extends JPanel {
   private static final String[] COLUMN_NAMES = {"Mon", "Tues", "Wed", "Thurs", "Fri"};
   private JButton button = new JButton("Button");
   private DefaultTableModel model = new DefaultTableModel(COLUMN_NAMES, 10);
   private JTable table = new JTable(model);

   public TableAndButton() {
      JPanel btnPanel = new JPanel();
      btnPanel.add(button);

      table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            boolean anyRowSelected = !(lsm.isSelectionEmpty());
            button.setEnabled(anyRowSelected);
         }
      });

      button.setEnabled(false);

      setLayout(new BorderLayout());
      add(new JScrollPane(table), BorderLayout.CENTER);
      add(btnPanel, BorderLayout.PAGE_END);
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("TableAndButton");
      frame.getContentPane().add(new TableAndButton());
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