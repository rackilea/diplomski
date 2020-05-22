import javax.swing.*;
import javax.swing.table.*;

public class RemoveAddRows extends JFrame {

    private static final long serialVersionUID = 1L;
    private Object[] columnNames = {"Type", "Company", "Shares", "Price"};
    private Object[][] data = {
        {"Buy", "IBM", new Integer(1000), new Double(80.50)},
        {"Sell", "MicroSoft", new Integer(2000), new Double(6.25)},
        {"Sell", "Apple", new Integer(3000), new Double(7.35)},
        {"Buy", "Nortel", new Integer(4000), new Double(20.00)}
    };
    private JTable table;
    private DefaultTableModel model;
    private javax.swing.Timer timer = null;

    public RemoveAddRows() {
        model = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table = new JTable(model);        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);        
    }



    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                RemoveAddRows frame = new RemoveAddRows();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}