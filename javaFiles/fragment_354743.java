import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class MyTable {

    private JFrame frame = new JFrame("TableDemo");
    private JScrollPane tableScroll = new JScrollPane();
    private MyTableModel tableModel = new MyTableModel();
    private JTable dialogTable = new JTable(tableModel);

    public MyTable() {
        dialogTable.setPreferredScrollableViewportSize(dialogTable.getPreferredSize());
        tableScroll = new JScrollPane(dialogTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(tableScroll);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        System.out.println(dialogTable.getRowCount());
        System.out.println(dialogTable.getColumnCount());
        System.out.println(tableModel.getRowCount());
        System.out.println(tableModel.getColumnCount());
    }

    private class MyTableModel extends AbstractTableModel {

        private String[] columnNames = {"Termin", "Ime i prezime", "Napomena"};
        private String[][] data = {{"7:00", null, null}, {"8:00", null, null}, 
            {"9:00", null, null}, {"10:00", null, null}, {"11:00", null, null}, 
            {"12:00", null, null}};

        @Override
        public void addTableModelListener(TableModelListener arg0) {
            // TODO Auto-generated method stub
        }

        @Override
        public Class<?> getColumnClass(int columnNames) {
            switch (columnNames) {
                case 0:
                    return String.class;//return Date.class;
                case 1:
                    return String.class;//return Double.class;
                case 2:
                    return String.class;//return Boolean.class;
                default:
                    return String.class;
            }
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.length;   //  <<----- this line is problem
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            if (col > 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void removeTableModelListener(TableModelListener arg0) {
            // TODO Auto-generated method stub
        }

        @Override
        public void setValueAt(Object data, int row, int col) {
            // TODO Auto-generated method stub
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyTable myTable = new MyTable();
            }
        });
    }
}