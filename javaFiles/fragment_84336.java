public class RecordTableModel extends AbstractTableModel {
...
    public void updateRow(int modelRow,...) {
    String query = ...;
    Connection conn;
    PreparedStatement pstate;
    try {
        conn = DriverManager.getConnection(...);
        pstate = conn.prepareStatement(query);
        pstate.executeUpdate();
        fireTableRowsUpdated(modelRow, modelRow);     // Not Work!
        fireTableDataChanged();                       // Not Work!
        fireTableCellUpdated(modelRow, 1);           // Not Work!
    } catch (SQLException sql) {
        sql.printStackTrace();
    }
}