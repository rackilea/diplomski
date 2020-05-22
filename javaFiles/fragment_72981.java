import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;


public class SqlDemo {

    private static final String SELECT_USER_ROLE_SQL =
            "SELECT m.user_name, m.user_role " +
            "FROM User as u " +
            "JOIN Usermap as m" +
            "ON u.user_name = m.user_name ";

    public Map<String, String> getAllUserRoles(Connection connection) {
        Map<String, String> userRoles = new LinkedHashMap<String, String>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(SELECT_USER_ROLE_SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                String user = rs.getString("user_name");
                String role = rs.getString("user_role");
                userRoles.put(user, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close(rs);
            close(ps);
        }

        return userRoles;
    }

    private static void close(ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void close(Statement st) {
        try {
            if (st != null) st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}