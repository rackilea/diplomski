import javax.sql.DataSource;

public class TCSOracleDataSourceWrapper implements DataSource {
  ...
  private DataSource wrappedDataSource;
  ...

  public TCSOracleDataSourceWrapper(DataSource ds) {
    wrappedDataSource = ds;
  }

  ...

  public final Connection getConnection() throws SQLException {
    ...

    Connection connection = null;
    try{
        connection = ds.getConnection();         
    }
    catch(SQLException e)
    {
        ...
    }       

    return connection;
  }
}