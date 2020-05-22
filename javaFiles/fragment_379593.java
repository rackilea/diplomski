SQLBatchHandler h = new SQLBatchHandler(conn, "UPDATE ... WHERE ? ? ? ... ");
  h.addToBatch(x, y,z);
  h.addToBatch(x2,y2,z2);
  ...
  h.flush();



public class SQLBatchHandler {
    public static int           MAX_BATCH_SIZE  = 500;
    public String           query;
    private Connection      conn;
    private PreparedStatement   ps;
    private int             batch_ct;

    public SQLBatchHandler(Connection c, String query) throws SQLException
        {
        conn = c;
        this.query = query;
        ps = conn.prepareStatement(query);
    }

    /**
     * add this row to the batch and handle the commit if the batch size
     * exceeds {@link #MAX_BATCH_SIZE}
     * 
     * @param values row values
     * @throws SQLException
     */
    public void addToBatch(Object ... values) throws SQLException
    {
        int i = 0;
        for (Object value: values)
        {
            ps.setObject((++i), value);
        }
        add();
    }

    private void add() throws SQLException
    {
        ps.addBatch();
        if ((++batch_ct) > MAX_BATCH_SIZE)
        {
            ps.executeBatch();
            batch_ct = 0;
        }
    }

    /**
     * Commit any remaining objects and close.
     * 
     * @throws SQLException On statement close error.
     */
    public void flush() throws SQLException
    {
        if (batch_ct == 0) { return; }
        try
        {
            ps.executeBatch();
        }
        catch (SQLException e)
        {
            throw e;
        }
        finally
        {
            if (ps != null)
            {
                ps.close();
            }
        }
    }
}