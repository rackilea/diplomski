import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import org.jdesktop.swingx.JXTable;

public class TableTest extends JFrame {

    public TableTest() {
        super("JXTable - first 3 rows aren't sorted");
        setLayout(new BorderLayout());

        MyTableModel model = new MyTableModel();
        JXTable table = new JXTable();
        table.setModel(model);

        Object[][] initialData = {
            {"Zoe", new Integer(26)},
            {"Adam", new Integer(29)},
            {"Trisha", new Integer(33)},
            {"Reed", new Integer(20)},
            {"John", new Integer(3)},
            {"Kyle", new Integer(102)},
            {"Billy Bob", new Integer(27)},
            {"Sandra", new Integer(87)},
            {"Steve", new Integer(50)},
            {"Guy", new Integer(23)},
            {"Kenzie", new Integer(25)},
            {"Mary", new Integer(27)},
            {"Sally", new Integer(12)},
            {"Joe", new Integer(101)},
            {"Billy", new Integer(44)},
            {"Bob", new Integer(83)},
        };
        model.setData(initialData);

        JScrollPane tableScroll = new JScrollPane(table);
        add(tableScroll, BorderLayout.CENTER);

        table.setFillsViewportHeight(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private class MyTableModel extends AbstractTableModel {

        String[] columns = { "First Name", "Age" };
        Object[][] data = {};

        public void setData(Object[][] data) {
            for (int i=0; i<data.length; i++) {
                // Don't sort top 3 rows
                boolean sorted = i < 3 ? false : true;

                // Wrap each object so the sorting can be manipulated.
                // Change these class types as needed.
                data[i][0] = new ComparableWrapper<String>((String) data[i][0], sorted);
                data[i][1] = new ComparableWrapper<Integer>((Integer) data[i][1], sorted);
            }
            this.data = data;
            fireTableDataChanged();
        }

        @Override
        public Class<?> getColumnClass(int col) {
            return ComparableWrapper.class;
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public String getColumnName(int col) {
            return columns[col];
        }

    }

    private class ComparableWrapper<T> implements Comparable<ComparableWrapper<T>> {

        private Comparable<T> object;
        private boolean sorted;

        public ComparableWrapper(Comparable<T> object, boolean sorted) {
            this.object = object;
            this.sorted = sorted;
        }

        @Override
        public int compareTo(ComparableWrapper<T> o) {
            if (object instanceof Comparable<?>) {
                if (sorted && o.isSorted()) {
                    // Sort normally by default
                    return object.compareTo(o.getObject());
                } else {
                    // If an un-sorted row is being compared, don't compare at all
                    return 0;
                }
            }

            // Fallback
            return 0;
        }

        public T getObject() {
            return (T) object;
        }

        public boolean isSorted() {
            return sorted;
        }

        @Override
        public String toString() {
            return object.toString();
        }

    }

    public static void main(String[] args) {
        new TableTest();
    }

}