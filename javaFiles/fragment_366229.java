import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Main {
    public static void main(String[] args) {
        new Main();
    }
    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Column 1");
            model.addColumn("Column 2");
            model.addColumn("Column 3");
            model.addColumn("Column 4");
            model.setRowCount(100);

            JTable table = new JTable(model);
            add(new JScrollPane(table));

            JToggleButton toggle = new JToggleButton("Toggle");
            toggle.addActionListener(new ActionListener() {
                private TableColumn column;
                @Override
                public void actionPerformed(ActionEvent e) {
                    TableColumnModel columnModel = table.getColumnModel();
                    if (toggle.isSelected()) {
                        column = columnModel.getColumn(0);
                        table.getColumnModel().removeColumn(column);
                    } else if (column != null) {
                        columnModel.addColumn(column);
                        columnModel.moveColumn(columnModel.getColumnCount() - 1, 0);
                    }
                }
            });
            add(toggle, BorderLayout.SOUTH);
        }

    }
}