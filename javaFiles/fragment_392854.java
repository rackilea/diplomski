import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TestTable {


    private DefaultTableModel myTableModel = getModel();
    private JTable table = new JTable(myTableModel);

    public TestTable() {
        JButton button = new JButton("Remove All");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for(int row = 0; row < table.getRowCount(); ++row) {
                    if((Boolean) table.getValueAt(row, 3) == true) {
                        System.out.println("true");
                        myTableModel.removeRow(row);
                        row--;
                    }
                } 
            }
        });

        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.add(button, BorderLayout.PAGE_END);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private DefaultTableModel getModel() {
        String[] columnNames = {"Name",
                "Age",
                "Salary",
        "Delete"};

        Object[][] data = {
                {"Kathy", "20",new Integer(5), new Boolean(false)},
                {"John", "35", new Integer(3), new Boolean(false)},
                {"Sue", "20", new Integer(2), new Boolean(false)},
                {"Jane", "12", new Integer(20), new Boolean(false)},
                {"Mary", "42", new Integer(10), new Boolean(false)}
        };
        return new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int col) {
                switch(col) {
                case 0: 
                case 1: return String.class;
                case 2: return Integer.class;
                case 3: return Boolean.class;
                default: return Object.class;
                }
            }
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestTable();
            }
        });
    }
}