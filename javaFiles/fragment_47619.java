Connection conn;
try
{   
    // Obtain our environment naming context
    Context initCtx = new InitialContext();
    Context envCtx = (Context) initCtx.lookup("java:comp/env");

    // Look up our data source
    DataSource ds = (DataSource)
      envCtx.lookup("jdbc/NexusIRM");

    // Allocate and use a connection from the pool
    Connection conn = ds.getConnection();
    ... use this connection to access the database ...
}
finally
{
   if(conn != null)
       conn.close();
}