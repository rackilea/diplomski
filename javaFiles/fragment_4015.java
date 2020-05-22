PreparedStatement pst=null;
    ResultSet rs=null;
    String userName = "someUser";
    String userClass;
    pst=con.prepareStatement("select * from SC_users where Username=? ");
    pst.setString(1,userName);
    rs=pst.executeQuery();
        if(rs.next())
        {
            userClass=rs.getString("Class");
        }