import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class TestTableCellRenderer {

    public static void main(String[] args) {
        new TestTableCellRenderer();
    }

    public TestTableCellRenderer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTable table = new JTable();
                table.setModel(new TableModel());
                table.setDefaultRenderer(Boolean.class, new BooleanCellRenderer());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TableModel extends AbstractTableModel {

        private List<Boolean> values = new ArrayList<>(25);

        public TableModel() {
            for (int index = 0; index < 25; index++) {
                values.add((((int) Math.round(Math.random() * 1)) == 0 ? false : true));
            }
        }

        @Override
        public int getRowCount() {
            return values.size();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return values.get(rowIndex);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return Boolean.class;
        }
    }

    public static class BooleanCellRenderer extends JCheckBox implements TableCellRenderer {

        private static final Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

        public BooleanCellRenderer() {
            setLayout(new GridBagLayout());
            setMargin(new Insets(0, 0, 0, 0));
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Boolean) {
                setSelected((Boolean) value);
            }
            if (!isSelected) {
                setBackground(new Color(0xFFFFFF));
                if (row % 2 == 1) {
                    setBackground(new Color(0xE8F2FE)); //light blue
                }
                setForeground(Color.black);
            } else {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            }
            if (hasFocus) {
                setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
            } else {
                setBorder(noFocusBorder);
            }
            return this;
        }
    }
}