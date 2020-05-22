public interface QueryAndRetrieval {

    public String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public String JDBC_URL = "jdbc:derby:CompanyDB;create=true";

    public boolean containsEntry(String TableName, Object key);

    public abstract Connection connect() throws SQLException;
}

public abstract class QueryAndRetrievalBase {
    public Connection conn;

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(QueryAndRetrieval.JDBC_URL);
    }
}

public class MyQueryImpl extends QueryAndRetrievalBase { ... }