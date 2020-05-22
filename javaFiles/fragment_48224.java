import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DataIntoTable extends JPanel {

   private static final String[] COL_NAMES = {"First Name", "LastName"};
   private DefaultTableModel model = new DefaultTableModel(COL_NAMES, 0);
   private JTable table = new JTable(model);
   private JTextField firstNameField = new JTextField(10);
   private JTextField lastNameField = new JTextField(10);
   private JPanel dialogPanel = new JPanel();

   public DataIntoTable(final JFrame frame) {
      setLayout(new BorderLayout());
      add(new JScrollPane(table));

      dialogPanel.add(new JLabel("First Name:"));
      dialogPanel.add(firstNameField);
      dialogPanel.add(new JLabel("Second Name:"));
      dialogPanel.add(lastNameField);

      dialogPanel.add(new JButton(new AbstractAction("Submit") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            String[] rowData = {firstNameField.getText(), lastNameField.getText()};
            model.addRow(rowData);
            firstNameField.setText("");
            lastNameField.setText("");
         }
      }));

      JDialog dialog = new JDialog(frame, "Enter Name", false);
      dialog.getContentPane().add(dialogPanel);
      dialog.pack();
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);

   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Data Into Table");
      DataIntoTable mainPanel = new DataIntoTable(frame);

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