PreparedStatement stmt=con.prepareStatement("SELECT firstName FROM user WHERE username = ?;");  
stmt.setString(1, userName);

ResultSet rs=stmt.executeQuery();

if(rs.next())  {
    fname=new String(rs.getString(1));
    System.out.println("First Name:"+firstname);  
}