@Stateless
public class SomeEJB {

   @Resource(name="java:/MySqlDS")
   private DataSource ds;

   public String test() {
        String output = "";

        String query="select * from clients";

        try {
            try (Connection conn = ds.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while(rs.next())
                {
                    output += rs.getInt("id");
                    output += rs.getString("username");
                    output += rs.getString("birth_date");
                    output += rs.getString("name");
                    output += rs.getString("surename");
                }
            } 
        } catch (SQLException e) {
            return e.toString();
        }

        return output;
    }
}