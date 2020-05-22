import javax.swing.*;
import javax.swing.table.*;

public class Foo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Object columnNamesPax[] = { "#", "Name", "Surname", "Sex",
                        "Age", "Class" };
                Object[][] data = new Object[5][columnNamesPax.length];

                JTable tablePax = new JTable(new DefaultTableModel(data,
                        columnNamesPax));

                DefaultTableModel defaultModel = (DefaultTableModel) tablePax
                        .getModel();
                System.out.println(tablePax.getColumnCount());
                defaultModel.addRow(new Object[] { "1", "2", "3", "4", "5", "6" });

                JOptionPane.showMessageDialog(null, new JScrollPane(tablePax));
            }
        });
    }
}