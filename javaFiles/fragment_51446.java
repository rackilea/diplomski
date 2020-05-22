import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/** @see https://stackoverflow.com/questions/9132987 */
public class EnvTableTest extends JPanel {

    public EnvTableTest() {
        this.setLayout(new GridLayout());
        this.add(new JScrollPane(new JTable(new EnvDataModel())));
    }

    private static class EnvDataModel extends AbstractTableModel {

        private Map<String, String> data = System.getenv();
        private String[] keys;

        public EnvDataModel() {
            keys = data.keySet().toArray(new String[data.size()]);
        }

        @Override
        public String getColumnName(int col) {
            if (col == 0) {
                return "Key";
            } else {
                return "Value";
            }
        }

        @Override
        public int getColumnCount() {
            return 2;
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
        JFrame f = new JFrame("EnvTableTest");
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
                new EnvTableTest().display();
            }
        });
    }
}