import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class TestTableModel02 {

    public static void main(String[] args) {
        new TestTableModel02();
    }

    public TestTableModel02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(new JTable(new DataTableModel())));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class DataTableModel extends AbstractTableModel {

        private Object[][] data;
        private String[] header = {"", "KB Name", "fpGUID"};

        public DataTableModel() {//throws SQLException {
            // ========= CONNECTS TO DB AND PULLS RESULTS ==========

            // GETS RESULTS SET CALLED "rs"

            // populate data array
//            int counter = 0;
//            while (rs.next()) {
//                //data[counter][0] = "sfsdfsdfs ";
//                data[counter][1] = (String) rs.getObject(2);
//                data[counter][2] = (String) rs.getObject(4);
//
//                counter++;
//            }
            // =====================================================

            data = new Object[4][3];
            data[0] = new Object[]{false, "Help", "1234"};
            data[1] = new Object[]{false, "On fire", "5648"};
            data[2] = new Object[]{false, "Drowning", "9012"};
            data[3] = new Object[]{false, "Micky Mouse", "3456"};
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return col == 0;
        }

        @Override
        public Class getColumnClass(int column) {
            if (column == 0) {
                return Boolean.class;
            } else {
                return String.class;
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                if (aValue instanceof Boolean) {
                    data[rowIndex][columnIndex] = (Boolean)aValue;
                    fireTableCellUpdated(rowIndex, columnIndex);
                }
            }
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return header.length;
        }

        @Override
        public String getColumnName(int column) {
            return header[column];
        }
    }
}