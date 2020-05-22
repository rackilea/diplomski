import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Arrays;
import java.util.Vector;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableFoo extends JPanel {
   private static final Vector<String> COLUMN_NAME_VECTOR = new Vector<String>(
         Arrays.asList(new String[] { "A", "B", "C" }));
   private static final int COLUMN_COUNT = COLUMN_NAME_VECTOR.size();
   private JTable table = new JTable();
   private Random rand = new Random();

   public TableFoo() {
      table.setFillsViewportHeight(true);
      table.setForeground(Color.WHITE);
      table.setBackground(Color.BLACK);

      JButton changeData = new JButton(new ChangeDataAction());
      JPanel southPanel = new JPanel();
      southPanel.setBackground(Color.black);
      southPanel.add(changeData);

      setLayout(new BorderLayout());
      add(new JScrollPane(table), BorderLayout.CENTER);
      add(southPanel, BorderLayout.PAGE_END);
   }

   public void changeTableData() {
      Vector<Vector<String>> matrix = new Vector<Vector<String>>();

      int rowCount = rand.nextInt(5) + 3;
      for (int i = 0; i < rowCount ; i++) {
         Vector<String> row = new Vector<String>();
         for (int j = 0; j < COLUMN_COUNT; j++) {
            String rowText = String.format("row %d col %d:   %d", i, j, rand.nextInt(100));
            row.add(rowText );
         }
         matrix.add(row);
      }

      DefaultTableModel model = new DefaultTableModel(matrix,
            COLUMN_NAME_VECTOR);

      table.setModel(model);
   }

   private class ChangeDataAction extends AbstractAction {
      public ChangeDataAction() {
         super("Change Action");
      }

      public void actionPerformed(java.awt.event.ActionEvent arg0) {
         changeTableData();
      };
   }

   private static void createAndShowGui() {
      TableFoo mainPanel = new TableFoo();

      JFrame frame = new JFrame("TableFoo");
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