import java.awt.EventQueue;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * @see http://stackoverflow.com/a/25736893/230513
 */
public class Test {

    private static class Account {

        public Account() {
        }
    }

    class AccountTableModel extends AbstractTableModel {

        LinkedList<Account> dataList = new LinkedList<>();
        private String[] columnNames = {"Username", "Password"};

        public void setNewAccounts(LinkedList<Account> inAccs) {
            dataList.clear();
            dataList.addAll(inAccs);
            this.fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return dataList.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Account account = dataList.get(row);
            if (col == 0) {
                return account.getClass();
            }
            if (col == 1) {
                return account.hashCode();
            }
            return null;
        }
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AccountTableModel model = new AccountTableModel();
        LinkedList<Account> list = new LinkedList<>();
        list.add(new Account());
        list.add(new Account());
        list.add(new Account());
        model.setNewAccounts(list);
        f.add(new JScrollPane(new JTable(model)));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Test().display();
        });
    }
}