import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableBooleanFilterDemo {

    public TableBooleanFilterDemo() {
        JTable table = getTable();
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        RowFilter filter = getRowFilter();
        rowSorter.setRowFilter(filter);
        table.setRowSorter(rowSorter);

        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private static final int CHECKBOX_COLUMN = 4;

    private RowFilter getRowFilter() {
        RowFilter<TableModel, Integer> filter = new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                int modelRow = entry.getIdentifier();
                Boolean checked = (Boolean)entry.getModel().getValueAt(modelRow, CHECKBOX_COLUMN);
                return checked;
            }
        };
        return filter;
    }

    private JTable getTable() {
        Object[][] data = {
            {"Kathy", "Smith",
                "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
                "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
                "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
                "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
                "Pool", new Integer(10), new Boolean(false)}
        };
        String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};
        return new JTable(new DefaultTableModel(data, columnNames) {
            public Class getColumnClass(int c) {
                return getValueAt(0, c).getClass();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TableBooleanFilterDemo();
            }
        });
    }
}