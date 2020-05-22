public class DBConnectionManager 
{
    public static final String DB_URL = "jdbc/RSRC/my/connection/mydb"

    public Connection getConnection (String jndiLookup)
    {
        DataSource ds = ServiceLocator.getInstance().getDataSource(jndiLookup);

        return ds.getconnection();
    } 

    public Connection getConnection(String driver, String url, String username, String password)
        throws ClassNotFoundException, SQLException
    {
        Class.forName(driver);

        return DriverManager.getConnection(url, username, password);
    }
}

public class MyDAO 
{
    private Connection connection;

    public MyDao(Connection connection)
    {
        this.connection = connection;
    }

    public SomeBean getContents (String id)
    {
        CallableStatement cs = this.connection.prepareCall("{call myStorProc(?)}");
        this.connection.setString(1, id);

        //code to call resultset and retrieve SomeBean goes here

        return someBean;                
    }
}