import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TabularData extends JPanel {
   private static final String FILE_NAME = "dataFile.txt"; // **** this is wrong ****
   private static final String[] COLUMN_NAMES = {"Species", "Count"};
   private static final String REGEX = "\\s+";
   private MyModel myModel = new MyModel();
   private JTable table = new JTable(myModel);

   public TabularData() {
      add(new JScrollPane(table));

      File dataFile = new File(FILE_NAME);
      try(BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
         String currentLine = "";
         while ((currentLine = br.readLine()) != null) {
            String[] tokens = currentLine.split(REGEX);
            if (tokens.length == 2) {
               String species = tokens[0].trim();
               int count = Integer.parseInt(tokens[1].trim());
               myModel.addRow(new Object[]{species, count});
            }
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (NumberFormatException e) {
         e.printStackTrace();
      }
   }

   private class MyModel extends DefaultTableModel {

      public MyModel() {
         super(COLUMN_NAMES, 0);
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
         if (getRowCount() > 0) {
            Object cell = getValueAt(0, columnIndex);
            if (cell != null) {
               return cell.getClass();
            }
         }
         return super.getColumnClass(columnIndex);
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("TabularData");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new TabularData());
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