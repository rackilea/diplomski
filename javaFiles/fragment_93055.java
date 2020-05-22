import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class TableJunk extends JPanel {
   enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
   MyTableModel tableModel = new MyTableModel();
   private JTable myTable = new JTable(tableModel);

   public TableJunk() {
      setLayout(new BorderLayout());
      add(new JScrollPane(myTable));

      Object[] rowData = {Day.MONDAY, Boolean.TRUE};
      tableModel.addRow(rowData );
      rowData = new Object[]{Day.TUESDAY, Boolean.TRUE};
      tableModel.addRow(rowData );
      rowData = new Object[]{Day.WEDNESDAY, Boolean.TRUE};
      tableModel.addRow(rowData );
      rowData = new Object[]{Day.THURSDAY, Boolean.TRUE};
      tableModel.addRow(rowData );
      rowData = new Object[]{Day.FRIDAY, Boolean.TRUE};
      tableModel.addRow(rowData );
      rowData = new Object[]{Day.SATURDAY, Boolean.FALSE};
      tableModel.addRow(rowData );
      rowData = new Object[]{Day.SUNDAY, Boolean.FALSE};
      tableModel.addRow(rowData );

      // create the combo box for the column editor          
      JComboBox<Day> comboBox = new JComboBox<TableJunk.Day>(Day.values());
      myTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));
   }

   private static void createAndShowGui() {
      TableJunk mainPanel = new TableJunk();

      JFrame frame = new JFrame("TableJunk");
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


   private static class MyTableModel extends DefaultTableModel {
      private static final String[] COLUMN_NAMES = {"Day", "Work Day"};

      public MyTableModel() {
         super(COLUMN_NAMES, 0);
      }

      // this method will allow the check box to be rendered in the 2nd column
      public java.lang.Class<?> getColumnClass(int columnIndex) {
         if (columnIndex == 0) {
            return Day.class;
         } else if (columnIndex == 1) {
            return Boolean.class;
         } else {
            return super.getColumnClass(columnIndex);
         }
      };
   }
}