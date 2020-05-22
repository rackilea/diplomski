/**
 * Simple wrapper around Object[] representing a row from the ResultSet.
 */
private class Row {
  private final Object[] values;

  public Row(Object[] values) {
    this.values = values;
  }

  public int getSize() {
    return values.length;
  }

  public Object getValue(int i) {
    return values[i];
  }
}

// TableModel implementation that will be populated by SwingWorker.
public class ResultSetTableModel extends AbstractTableModel {
  private final ResultSetMetaData rsmd;
  private final List<Row> rows;

  public ResultSetTableModel(ResultSetMetaData rsmd) {
    this.rsmd = rsmd;
    this.rows = new ArrayList<Row>();
  }

  public int getRowCount() {
    return rows.size();
  }

  public int getColumnCount() {
    return rsmd.getColumnCount();
  }

  public Object getValue(int row, int column) {
    return rows.get(row).getValue(column);
  }

  public String getColumnName(int col) {
    return rsmd.getColumnName(col - 1); // ResultSetMetaData columns indexed from 1, not 0.
  }

  public Class<?> getColumnClass(int col) {
    // TODO: Convert SQL type (int) returned by ResultSetMetaData.getType(col) to Java Class.
  }
}

// SwingWorker implementation
new SwingWorker<Void, Row>() {
  public Void doInBackground() {
    // TODO: Process ResultSet and create Rows.  Call publish() for every N rows created.
  }

  protected void process(Row... chunks) {
    // TODO: Add to ResultSetTableModel List and fire TableEvent.
  }
}.execute();