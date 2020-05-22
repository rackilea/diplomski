import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.*;

public class AddToTable {

  public static void main(String[] args) {

    JTable jTable = new JTable(new DefaultTableModel(
        new Object[][] {},
        new String[] {"Item", "Qty", "Price", "ID"}));

    JComboBox<String> jComboBox = new JComboBox<>();
    jComboBox.addItem("Item1 _ 2 _ 2.5 _ 101");
    jComboBox.addItem("Item2 _ 5 _ 6 _ 201");
    jComboBox.addItem("Item3 _ 3 _ 1.5 _ 301");

    jComboBox.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        Object items = jComboBox.getSelectedItem();
        String name = (String) items;
        String[] part = name.split(" _ ");
        String item = (part[0]);
        Integer qty = Integer.valueOf((part[1]));
        Double price = Double.parseDouble((part[2]));
        Integer ids = Integer.valueOf(part[3]);

        DefaultTableModel df = (DefaultTableModel) jTable.getModel();
        int rows = df.getRowCount();
        boolean found = false;
        for (int i = 0; i < rows; i++) {
          if (ids.equals(jTable.getValueAt(i, 3))) {
            Integer newQty = qty + (Integer) jTable.getValueAt(i, 1);
            Double newPrice = price + (Double) jTable.getValueAt(i, 2);
            jTable.setValueAt(newQty, i, 1);
            jTable.setValueAt(newPrice , i, 2);
            found = true;
            break;
          }
        }
        if (!found) {
          df.addRow(new Object[]{item, qty, price, ids});
        }
      }
    });

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(jComboBox, BorderLayout.NORTH);
    f.getContentPane().add(new JScrollPane(jTable), BorderLayout.CENTER);
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}