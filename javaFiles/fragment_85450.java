try{
    Class.forName("com.mysql.jdbc.Driver"); // loading driver class
    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Database_name", username,password); // getting connection may change depending on database you are using
    PreparedStatement ps = cn.prepareStatement("select name,sirname from user where id = ?");

                ps.setString(1,id);

             ResultSet rs =   ps.executeQuery();
                int i=0;
                while(rs.next())
                {
                    String name = rs.getString("name");
                    //  retrieve your fields
                }

}catch(Exception e)
{
     e.printStackTrace();
}