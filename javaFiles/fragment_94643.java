public class DBUtil {

    static DataSource ds;
    static {
        try {
            Context context = new InitialContext();
            ds = (DataSource)context.lookup("java:comp/env/rhwebDB");
        } catch (NamingException e) {
            System.out.println("DBUtil.NamingException" + e);
        } catch (SQLException e) {
            System.out.println("DBUtil.SQLException" + e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}