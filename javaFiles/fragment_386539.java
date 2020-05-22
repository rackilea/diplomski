public int generateid() {
    int count = 0;
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://IP:PORT;DatabaseName=SubscriberManager;integratedSecurity=true;");
        System.out.println("Connection Successfull");
        System.out.println(conn); 

        Statement stmt = conn.createStatement();
        String query1= "SELECT COUNT(*) from dbo.vSubscriberReporting where [SubscriberEmailAddressStatusID] in (5,1,6,7) and [SubscriberStatusID] = 1 AND [SubscriberAddresseeStatusID] = 1 and CompanySizeCodeID IN (4)";
        ResultSet rs= stmt.executeQuery(query1);

        if(rs.next()) //Expecting one row.
        {
            count = rs.getInt(1);
            System.out.println("Value: " + count);
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return count;
}