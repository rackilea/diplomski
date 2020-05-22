if (!rs.next()) 
{
    System.out.println("No Records Found");
}
else
{
    while(rs.next())
    { 
        System.out.println(rs.getString("value1");
        System.out.println(rs.getString("value2");
    }
}