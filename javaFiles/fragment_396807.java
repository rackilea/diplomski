import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Enumeration;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class Smile {

    public static void main(String[] args) {
        new Smile();
    }

    public Smile() {
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

        private double[][] smily = {
            {1, 1, 1, 1, 1, 0.996, 1, 0.843, 0.784, 0.788, 0.773, 0.769, 0.765, 0.765, 0.788, 0.784, 0.847, 1, 0.996, 1, 1, 1, 1, 0.996},
            {1, 1, 1, 1, 1, 0.871, 0.733, 0.761, 0.847, 0.941, 0.941, 0.941, 0.941, 0.941, 0.933, 0.843, 0.761, 0.733, 0.871, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0.784, 0.733, 0.902, 0.941, 0.941, 0.941, 0.945, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.898, 0.733, 0.784, 1, 1, 1, 1},
            {1, 1, 1, 0.765, 0.773, 0.945, 0.945, 0.941, 0.929, 0.937, 0.941, 0.941, 0.945, 0.941, 0.957, 0.91, 0.941, 0.941, 0.941, 0.78, 0.761, 1, 1, 1},
            {1, 1, 0.808, 0.773, 0.941, 0.941, 0.941, 0.941, 0.294, 0.447, 0.941, 0.941, 0.941, 0.941, 0.702, 0.239, 0.886, 0.941, 0.945, 0.941, 0.78, 0.8, 1, 1},
            {1, 0.89, 0.725, 0.945, 0.941, 0.941, 0.945, 0.843, 0, 0, 0.922, 0.945, 0.941, 0.941, 0.408, 0, 0.663, 0.941, 0.941, 0.945, 0.941, 0.725, 0.89, 1},
            {0.992, 0.753, 0.902, 0.941, 0.945, 0.945, 0.941, 0.725, 0.051, 0, 0.808, 0.941, 0.941, 0.945, 0.294, 0.051, 0.553, 0.941, 0.941, 0.941, 0.941, 0.91, 0.741, 0.984},
            {0.871, 0.78, 0.941, 0.941, 0.945, 0.945, 0.941, 0.694, 0.051, 0, 0.784, 0.945, 0.941, 0.941, 0.278, 0, 0.518, 0.941, 0.941, 0.945, 0.941, 0.941, 0.78, 0.878},
            {0.816, 0.855, 0.941, 0.945, 0.945, 0.945, 0.941, 0.737, 0, 0.051, 0.82, 0.941, 0.941, 0.941, 0.302, 0.051, 0.565, 0.941, 0.949, 0.945, 0.941, 0.941, 0.863, 0.804},
            {0.8, 0.945, 0.941, 0.945, 0.945, 0.941, 0.941, 0.875, 0, 0, 0.937, 0.941, 0.941, 0.941, 0.443, 0, 0.694, 0.945, 0.945, 0.945, 0.945, 0.949, 0.941, 0.765},
            {0.769, 0.941, 0.945, 0.957, 0.961, 0.941, 0.945, 0.941, 0.443, 0.565, 0.945, 0.941, 0.941, 0.941, 0.769, 0.388, 0.918, 0.941, 0.941, 0.941, 0.945, 0.941, 0.941, 0.78},
            {0.753, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.953, 0.941, 0.941, 0.941, 0.941, 0.945, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.788},
            {0.741, 0.945, 0.839, 0.427, 0.624, 0.941, 0.941, 0.945, 0.941, 0.941, 0.941, 0.949, 0.945, 0.945, 0.941, 0.941, 0.941, 0.941, 0.941, 0.6, 0.376, 0.941, 0.945, 0.784},
            {0.749, 0.941, 0.914, 0.345, 0.647, 0.941, 0.945, 0.949, 0.945, 0.945, 0.941, 0.941, 0.945, 0.941, 0.945, 0.945, 0.945, 0.945, 0.941, 0.702, 0.384, 0.941, 0.941, 0.78},
            {0.796, 0.945, 0.941, 0.627, 0.592, 0.941, 0.941, 0.941, 0.945, 0.945, 0.945, 0.941, 0.949, 0.945, 0.941, 0.945, 0.945, 0.937, 0.945, 0.58, 0.631, 0.941, 0.937, 0.776},
            {0.812, 0.859, 0.941, 0.855, 0.384, 0.957, 0.941, 0.945, 0.945, 0.945, 0.941, 0.953, 0.941, 0.945, 0.945, 0.945, 0.941, 0.941, 0.941, 0.384, 0.941, 0.941, 0.867, 0.812},
            {0.871, 0.788, 0.941, 0.941, 0.533, 0.51, 0.941, 0.941, 0.941, 0.945, 0.949, 0.945, 0.945, 0.945, 0.941, 0.937, 0.941, 0.945, 0.522, 0.522, 0.941, 0.941, 0.792, 0.886},
            {0.992, 0.761, 0.914, 0.941, 0.941, 0.325, 0.612, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.624, 0.318, 0.941, 0.945, 0.91, 0.765, 0.988},
            {1, 0.882, 0.741, 0.941, 0.941, 0.922, 0.337, 0.475, 0.894, 0.941, 0.941, 0.941, 0.941, 0.941, 0.945, 0.894, 0.49, 0.325, 0.925, 0.941, 0.941, 0.753, 0.894, 1},
            {1, 1, 0.796, 0.78, 0.941, 0.941, 0.941, 0.592, 0.447, 0.565, 0.667, 0.737, 0.737, 0.667, 0.565, 0.451, 0.588, 0.941, 0.941, 0.941, 0.796, 0.808, 1, 1},
            {1, 1, 0.996, 0.753, 0.788, 0.941, 0.941, 0.941, 0.941, 0.702, 0.584, 0.557, 0.553, 0.592, 0.698, 0.906, 0.941, 0.945, 0.941, 0.796, 0.769, 0.996, 1, 1},
            {1, 1, 1, 1, 0.769, 0.745, 0.922, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.941, 0.918, 0.741, 0.776, 1, 1, 0.996, 1},
            {1, 0.996, 1, 1, 1, 0.851, 0.733, 0.773, 0.867, 0.945, 0.941, 0.941, 0.941, 0.941, 0.945, 0.867, 0.769, 0.725, 0.851, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0.984, 0.843, 0.78, 0.761, 0.78, 0.796, 0.796, 0.784, 0.765, 0.78, 0.835, 0.984, 1, 1, 1, 1, 1, 1}
        };

        public TestPane() {
            AsciiTableModel model = new AsciiTableModel();
            model.setData(smily);

            JTable table = new JTable(model);
            table.setRowHeight(24);
            Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
            while (columns.hasMoreElements()) {
                TableColumn col = columns.nextElement();
                col.setWidth(24);
                col.setPreferredWidth(24);
                col.setMinWidth(24);
                col.setMaxWidth(24);
            }
            table.setRowHeight(24);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.setDefaultRenderer(Object.class, new PaintTableCellRenderer());

            setLayout(new BorderLayout());
            add(new JScrollPane(table));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class PaintTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, "", isSelected, hasFocus, row, column);
            if (value instanceof Double) {
                double distance = (double) value;
                int part = (int) (255 * distance);
                Color color = new Color(part, part, part);
                setBackground(color);
            } else {
                setBackground(Color.WHITE);
            }
            return this;
        }

    }

    public class AsciiTableModel extends AbstractTableModel {

        private double[][] data;

        public AsciiTableModel() {
            data = new double[24][24];
        }

        public void setData(double[][] value) {
            data = value;
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return 24;
        }

        @Override
        public int getColumnCount() {
            return 24;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

    }

}