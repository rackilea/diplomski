public void deleteCoreUser(String email) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://db.com:3306/core","username","password");
        Statement stmt = con.createStatement();
        String sql = "SET @email = '" + email + "'";
        stmt.execute(sql);
        sql = "SET @userID = (SELECT id FROM USER WHERE email = @email)";
        stmt.execute(sql);
        sql = "DELETE FROM user_role_group WHERE user_id = @userID";
        stmt.execute(sql);
        sql = "DELETE FROM user_client_setup WHERE user_id = @userID";
        stmt.execute(sql);
        sql = "DELETE FROM USER WHERE id = @userID";
        stmt.execute(sql);
        con.close();
        System.out.println("Deleting user " + email + " from the Core DB");
    } catch(Exception e){ System.out.println(e);}
}