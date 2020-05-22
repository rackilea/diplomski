public void check(String username,String password)
{
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","username","password");
        PreparedStatement pt=con.prepareStatement("select username,password from authentication_table where username=?");
        pt.setString(1, username);
        ResultSet rs=pt.executeQuery();
        String orgUname="",orPass="";
        while(rs.next())
        {
            orgUname=rs.getString("username");
            orPass=rs.getString("password");

        }
        if(orPass.equals(password))
        {
            //do something
        }
        else
        {
            //do something
        }
    }
    catch(Exception e)
    {

    }