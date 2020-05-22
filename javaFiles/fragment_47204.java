import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TableBgDemo {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] rows = { { "Column 1", "Column 2" },
                { "Column 1", "Column 2" }, { "Column 1", "Column 2" },
                { "Column 1", "Column 2" } };

        Object[] columns = { "Column 1", "Column 2" };

        DefaultTableModel model = new DefaultTableModel(rows, columns);

        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setCellRenderer(new MyRenderer());
        table.setSelectionBackground(Color.CYAN);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }

    static public class MyRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);
            c.setForeground(Color.RED);
            return c;
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}