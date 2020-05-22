import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * @see https://stackoverflow.com/a/31082475/230513
 * @see https://stackoverflow.com/questions/7920068
 * @see https://stackoverflow.com/questions/4526779
 */
public class CheckOnce extends JPanel {

    private static final int CHECK_COL = 1;
    private static final Object[][] DATA = {
        {"One", Boolean.FALSE}, {"Two", Boolean.FALSE},
        {"Three", Boolean.FALSE}, {"Four", Boolean.FALSE},
        {"Five", Boolean.FALSE}, {"Six", Boolean.FALSE},
        {"Seven", Boolean.FALSE}, {"Eight", Boolean.FALSE},
        {"Nine", Boolean.FALSE}, {"Ten", Boolean.FALSE}};
    private static final String[] COLUMNS = {"Number", "CheckBox"};
    private DataModel dataModel = new DataModel(DATA, COLUMNS);
    private JTable table = new JTable(dataModel);

    public CheckOnce() {
        super(new BorderLayout());
        this.add(new JScrollPane(table));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setPreferredScrollableViewportSize(
             new Dimension(250, 10 * table.getRowHeight()));
    }

    private class DataModel extends DefaultTableModel {

        public DataModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public void setValueAt(Object aValue, int row, int col) {
            super.setValueAt(aValue, row, col);
        }

        @Override
        public Class<?> getColumnClass(int col) {
            if (col == CHECK_COL) {
                return getValueAt(0, CHECK_COL).getClass();
            }
            return super.getColumnClass(col);
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            Object o = getValueAt(row, col);
            boolean b = o instanceof Boolean && (Boolean) o;
            return col == CHECK_COL && !b;
        }
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("CheckOne");
        frame.add(new CheckOnce());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }
}