public boolean authUser(String user, String pass) throws Exception
{
    boolean authenticated = false;
    int id = 0;
    String username = "", password = "";

    Connection authConn = getConnection();

    Statement stat = authConn.createStatement();
    String query = ("SELECT * FROM users where userName='" + user + "';");
    ResultSet rs = stat.executeQuery(query);

    while(rs.next()){
        id = rs.getInt("id");
        username = rs.getString("user");
        password = rs.getString("pass");
    }

    authConn.close();

    if(username.equals(user)){
        if(password.equals(pass)){
           authenticated = true;
        }else{
           authenticated = false;
           System.out.println("Incorrect Password!");
        }
    }
    else{
        authenticated = false;
        System.out.println("Incorrect Username!");
    }
    return authenticated;
}