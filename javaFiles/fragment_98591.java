import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MyTableEg extends JPanel {
   private static final String[] COLUMNS = {"Column A", "Column B"};
   private DefaultTableModel model = new DefaultTableModel(COLUMNS, 0);
   private JTable table = new JTable(model);
   private JTextField fieldA = new JTextField(10);
   private JTextField fieldB = new JTextField(10);
   private JButton button = new JButton(new ButtonAction("Add Data", KeyEvent.VK_A));

   public MyTableEg() {
      JPanel topPanel = new JPanel();
      topPanel.add(fieldA);
      topPanel.add(fieldB);
      topPanel.add(button);

      setLayout(new BorderLayout());
      add(topPanel, BorderLayout.NORTH);
      add(new JScrollPane(table), BorderLayout.CENTER);
   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {

         // ***** here's the important bit of code

         Vector<String> rowData = new Vector<String>();  // create a row Vector
         rowData.add(fieldA.getText());    // fill it with data from JTextFields
         rowData.add(fieldB.getText());
         model.addRow(rowData);            // and add to table model
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("MyTableEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new MyTableEg());
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