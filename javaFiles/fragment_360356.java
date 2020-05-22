try
{
    pstmt = con.prepareStatement("Select * from login", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    rs = pstmt.executeQuery();
    if (!rs.next()) 
    {
        System.out.println("No Records Found");
    }
    else
    {
        rs.beforeFirst();
        while(rs.next())
        { 
            System.out.println(rs.getString("value1");
            System.out.println(rs.getString("value2");
        }
    }
}