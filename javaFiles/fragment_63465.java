import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.*;

public class TableBasic {

    private JFrame frame = new JFrame();
    private  String[] columnNames = {"Date", "String", "Long", "Boolean"};
    private Object[][] data = {
        {getJavaDate("13-11-2020"), "A", new Double(1), Boolean.TRUE},
        {getJavaDate("13-11-2018"), "B", new Double(2), Boolean.FALSE},
        {getJavaDate("12-11-2015"), "C", new Double(9), Boolean.TRUE},
        {getJavaDate("12-11-2015"), "D", new Double(4), Boolean.FALSE}
    };
    private DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        @Override
        public Class<?> getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    };
    private JTable table = new JTable(model);
    private JScrollPane scrollPane = new JScrollPane(table);
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public TableBasic() {
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setAutoCreateRowSorter(true);
        setRenderers();
        // DefaultRowSorter has the sort() method
        table.getRowSorter().toggleSortOrder(0);
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void setRenderers() {
        //TableColumnModel m = table.getColumnModel();
        //"Integer", "String", "Interger", "Double", "Boolean", "Double", "String", "Boolean", "Date"
        table.setDefaultRenderer(Date.class, new DateRenderer());
    }

    private Date getJavaDate(String s) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date d = sdf.parse(s);
            return d;

        } catch (ParseException ex) {
            Logger.getLogger(TableBasic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TableBasic frame = new TableBasic();
            }
        });
    }

    private class DateRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!(value instanceof Date)) {
                return this;
            }
            setText(DATE_FORMAT.format((Date) value));
            return this;
        }
    }
}