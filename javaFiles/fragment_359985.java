import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TestCheckedTable {

    public TestCheckedTable() {
        String[] cols = {"col 1", "col 2", "col 3"};
        Object[][] data = new Object[15][];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Object[]{"Hello", "World", false};
        }

        final DefaultTableModel model = new DefaultTableModel(data, cols) {
            @Override
            public Class<?> getColumnClass(int col) {
                return col == 2 ? Boolean.class : String.class;
            }
        };
        JTable table = new JTable(model);

        JButton button = new JButton("Delete Checked Rows");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    Boolean checked = (Boolean) model.getValueAt(i, 2);
                    if (checked) {
                        model.removeRow(i);
                        i--;
                    }
                }
            }
        });

        JFrame frame = new JFrame("test");
        frame.add(new JScrollPane(table));
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestCheckedTable();
            }

        });
    }
}