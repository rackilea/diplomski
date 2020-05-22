import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class IntercellSpacingTableHeader {

    private JFrame frame = new JFrame("Table Demo");
    private String[] columnNames = {"String", "Integer", "Float", "Double"};
    private Object[][] data = {
        {"aaa", new Integer(12), new Float(12.15), new Double(100.05)},
        {"bbb", new Integer(5), new Float(7.154), new Double(6.1555)},
        {"CCC", new Integer(92), new Float(0.1135), new Double(3.1455)},
        {"ddd", new Integer(12), new Float(31.15), new Double(10.05)},
        {"eee", new Integer(5), new Float(5.154), new Double(16.1555)},
        {"fff", new Integer(92), new Float(4.1135), new Double(31.1455)}};
    private TableModel model = new DefaultTableModel(data, columnNames) {

        private static final long serialVersionUID = 1L;

        @Override
        public Class<?> getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    };
    private JTable table = new JTable(model);

    public IntercellSpacingTableHeader() {
        int gapWidth = 10;
        int gapHeight = 5;
        table.setIntercellSpacing(new Dimension(gapWidth, gapHeight));
        table.setRowHeight(20);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scroll = new JScrollPane(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scroll);
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new IntercellSpacingTableHeader();
            }
        });
    }
}