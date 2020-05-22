import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TestTable2 {

    protected void initUI() {
        Vector<String> columnNames = new Vector<String>();
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        Connection conn = dbConnect.connect();
        String sql = "Select date, frequency, type, payeereceivee, amount, comments from schedule where date ='" + outputdate + "'";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columns = metaData.getColumnCount();
        for (int i = 1; i <= columns; i++) {
            columnNames.addElement(metaData.getColumnName(i));
        }
        while (resultSet.next()) {
            Vector row = new Vector(columns);
            for (int i = 1; i <= columns; i++) {
                row.addElement(resultSet.getObject(i));
            }
            data.addElement(row);
        }
        resultSet.close();
        statement.close();

        JTable tbl = new JTable(new DefaultTableModel(data, columnNames) {
            @Override
            public void setValueAt(Object aValue, int row, int column) {
                // Here update DB with a SwingWorker and the new provided value
                super.setValueAt(aValue, row, column);
            }
        });
        TableColumn column;
        for (int i = 0; i < tbl.getColumnCount(); i++) {
            column = tbl.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
        }
        JFrame frame = new JFrame(TestTable2.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollpane = new JScrollPane(tbl);
        frame.add(scrollpane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable2().initUI();
            }
        });
    }

}