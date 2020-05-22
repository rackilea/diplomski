public class User {
   private int userId;
   private String username;
   private Address address; // USE POJO not ID
}

public class Address{
   private int addressId;
   private String zip;
   List<User> users;
}
    public User getUserById(Connection con, long userId) {
        PreparedStatement stmt;
        String query = "select u.user_id, u.user_name, a.id, a.zip from user u, address a where a.address_id = u.id and u.id = ?";
        User user = new User();
        Address address = new Address;
        try {
            stmt = con.prepareStatement(query);
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            address.setId(rs.getInt("id"));
            address.setZip(rs.getString("zip");
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("user_name"));
            user.setAddressId(rs.getInt("address_id"));
            user.setAddress(address); // look here
        } catch (SQLException e) {
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch (SQLException excep) {
                }
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return user;
    }