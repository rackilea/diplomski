public static void main(String[] args) 
{
    try{
        String host = "jdbc:mysql://rds-ip:3306/rds-database-name";
        String uName = "rds-database-username";
        String uPass = "rds-database-pasword";
        Connection con = DriverManager.getConnection( host, uName, uPass );
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM tablename";
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        int id_col = rs.getInt("id");
        String column1 = rs.getString("column1");
        String column2 = rs.getString("column2");
         }
         catch(SQLException err){
        System.out.println(err.getMessage());
    }
}