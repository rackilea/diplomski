import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class JTableTest extends JFrame {
    private JTableTest()  {
        super("Button Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1));
        createPanel();
        pack();
        setVisible(true);
    }

    JPanel panel = new JPanel(new GridLayout(1, 1));
    JScrollPane scroll = new JScrollPane();

    private void createPanel() {
        Object[] headers = {"Select", "Title", "Artist", "Length"};
        Object[][] sampleData = {{true, "Bat Outta Hell", "Meat Loaf", "673"},
                {false, "Spanish Train", "Chris De Burgh", "358"}};
        JTable table = new JTable() {
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                c.setBackground(row % 2 == 1 ? Color.WHITE : Color.RED);
                ((JComponent) c).setBorder(null); //Left in so it is easier to see problem
                return c;
            }

            @Override
            public Component prepareEditor(TableCellEditor editor, int row, int column) {
                Component c = super.prepareEditor(editor, row, column);
                c.setBackground(row % 2 == 1 ? Color.WHITE : Color.RED);
                ((JComponent) c).setBorder(null); //Left in so it is easier to see problem
                return c;
            }
        };

        DefaultTableModel tableModel = new DefaultTableModel(sampleData, headers) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch(columnIndex) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };

        table.setModel(tableModel);
        table.setRowSelectionAllowed(false); //Left in so it is easier to see problem

        scroll.getViewport().add(table);
        panel.add(scroll);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater (
            new Runnable() {
                @Override
                public void run() {
                    new JTableTest();
                }
            }
        );
    }
}