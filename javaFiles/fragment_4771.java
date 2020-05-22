import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
* @see https://stackoverflow.com/q/12330167/230513
*/
public class TableModelTest extends JPanel {

    public TableModelTest() {
        super(new BorderLayout());
        final MyModel model = new MyModel();
        JTable table = new JTable(model);
        this.add(new JScrollPane(table));
        this.add(new JButton(new AbstractAction("Delete") {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.remove(0);
            }
        }), BorderLayout.SOUTH);
    }

    public class MyModel extends AbstractTableModel {

        private List<String> names = new ArrayList<String>();
        private Map<Point, Object> data = new HashMap<Point, Object>();
        private Point[] keys;

        public MyModel() {
            this.names = Arrays.asList("Point", "Name");
            data.put(new Point(1, 1), "One");
            data.put(new Point(2, 2), "Two");
            data.put(new Point(3, 3), "Three");
            this.keys = data.keySet().toArray(new Point[data.size()]);
        }

        public void remove(int row) {
            data.remove(keys[row]);
            keys = data.keySet().toArray(new Point[data.size()]);
            this.fireTableRowsDeleted(row, row);
        }

        @Override
        public int getColumnCount() {
            return names.size();
        }

        @Override
        public String getColumnName(int col) {
            return names.get(col);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public Object getValueAt(int row, int col) {
            if (col == 0) {
                return keys[row];
            } else {
                return data.get(keys[row]);
            }
        }
    }

    private void display() {
        JFrame f = new JFrame("TableModelTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TableModelTest().display();
            }
        });
    }
}