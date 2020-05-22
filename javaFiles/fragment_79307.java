import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JTablesSSCCE {

    private JFrame frame = new JFrame();
    private String[] columnNames = {"Nama", "Nim", "IP", "Hapus Baris ke"};
    private Object[][] data = {
        {"igor", null, "1.124.01.125", true},
        {"lenka", "B21_002-242", null, true},
        {"peter", null, "99.124.01.001", null},
        {"zuza", "B12_100-242", null, null},
        {"jozo", "BUS_011-358", null, false},
        {"nora", null, "9.124.01.154", null},
        {"xantipa", null, "1.124.01.001", false},};
    private DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            switch (column) {
                case 3: // only fourth column is editable
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 0:
                    return String.class;
                case 1:
                case 2:
                    return Integer.class;
                case 3:
                    return Boolean.class;
                default:
                    return null;
            }
        }
    };
    private JTable table = new JTable(model);

    public JTablesSSCCE() {
        table.setAutoCreateRowSorter(true);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableCellRenderer stringRenderer
                = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane pane = new JScrollPane(table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] arg) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTablesSSCCE();
            }
        });
    }
}