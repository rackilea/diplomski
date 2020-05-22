import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class DefaultTableModelDemo {

    public static final String[] COLUMN_NAMES = {
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
    };
    private DefaultTableModel model = new DefaultTableModel(COLUMN_NAMES, 0);
    private JTable table = new JTable(model);
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private Random random = new Random();

    public DefaultTableModelDemo() {
        JButton addDataButton = new JButton("Add Data");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addDataButton);
        addDataButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addDataActionPerformed();
            }
        });
        model = new DefaultTableModel(COLUMN_NAMES, 0) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (isRowSelected(row) && isColumnSelected(column)) {
                    ((JComponent) c).setBorder(new LineBorder(Color.red));
                }

                return c;
            }
        };
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addDataActionPerformed() {
        for (int i = 0; i < 5; i++) {
            Object[] row = new Object[COLUMN_NAMES.length];
            for (int j = 0; j < row.length; j++) {
                row[j] = random.nextInt(5);
            }
            model.addRow(row);
        }
    }

    public JComponent getComponent() {
        return mainPanel;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("DefaultTableModelDemo");
                frame.getContentPane().add(new DefaultTableModelDemo().getComponent());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}