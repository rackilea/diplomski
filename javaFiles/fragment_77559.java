import java.util.Random;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Foo2 {

   private static void createAndShowGui() {
      String[] columns = {"Spaltennamen", " Datentypen", "Datenzusatz"};
      String[] dataStrings1 = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
      String[] dataStrings2 = {"One", "Two", "Three", "Four", "Five"};
      Random random = new Random();

      DefaultTableModel model = new DefaultTableModel(columns, 0);
      int spaltenzahl = 10;  // this can change
      for (int i = 0; i < spaltenzahl; i++) {
         Vector<String> rowData = new Vector<>();
         rowData.add("Row Number " + (i + 1));
         rowData.add(dataStrings1[random.nextInt(dataStrings1.length)]);
         rowData.add(dataStrings2[random.nextInt(dataStrings2.length)]);
         model.addRow(rowData);
      }

      JTable table = new JTable(model);
      table.getColumn(columns[1]).setCellEditor(new DefaultCellEditor(new JComboBox<>(dataStrings1)));
      table.getColumn(columns[2]).setCellEditor(new DefaultCellEditor(new JComboBox<>(dataStrings2)));
      JScrollPane scrollPane = new JScrollPane(table);


      JFrame frame = new JFrame("Foo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(scrollPane);
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