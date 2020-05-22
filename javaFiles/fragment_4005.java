public abstract class AbstractModel { 

    //current arraylist code
    PreparedStatement stat;
     ResultSet result;
     Connection conn;
    protected ResultSet processQuery(String query,String username, String password) {

     try { 
            conn = SimpleDataSourceV2.getConnection(); 
            String _query = query;
            stat = conn.prepareStatement(query);
            stat.setString(1, username);
            stat.setString(2, password); 
   return result = stat.executeQuery(); 
    }
    } catch (SQLException ex) { 
         //.....
}
}