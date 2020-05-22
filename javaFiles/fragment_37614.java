import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * @see http://stackoverflow.com/a/18764073/230513
 */
public class Test {

    private static class MyTableModel extends AbstractTableModel {

        private String[] columns = {
            "Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        private String[][] data = {
            {"8:30 - 9:30", "", "", "", "", ""},
            {"9:30 - 10:30", "", "", "", "", ""},
            {"10:30 - 11:30", "", "", "", "", ""},
            {"11:30 - 12:30", "", "", "", "", ""},
            {"12:30 - 13:30", "", "", "", "", ""},
            {"13:30 - 14:30", "", "", "", "", ""},
            {"14:30 - 15:30", "", "", "", "", ""},
            {"15:30 - 16:30", "", "", "", "", ""},
            {"16:30 - 17:30", "", "", "", "", ""}};

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public String getColumnName(int col) {
            return columns[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public void setValueAt(Object aValue, int row, int col) {
            data[row][col] = (String) aValue;
            fireTableCellUpdated(row, col);
        }
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final TableModel model = new MyTableModel();
        f.add(new JScrollPane(new JTable(model) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(600, 128);
            }
        }));
        f.add(new JButton(new AbstractAction("Update") {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setValueAt(String.valueOf(e.getWhen() % 1000000), 1, 1);
            }
        }), BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}