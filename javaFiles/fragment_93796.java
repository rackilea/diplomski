public static boolean getConnection() {
    try {
        System.out.println(ServerName);
        ds = new SQLServerDataSource();
        ds.setServerName(ServerName);
        ds.setPortNumber(1433);
        ds.setDatabaseName(DatabaseName);
        ds.setUser(UserName);
        ds.setPassword(Password);
        con = ds.getConnection();
        if (con != null) {
            System.out.println("Success");
        }
        stmt = con.createStatement();
        return true;
    } // Handle any errors that may have occurred.
    catch (Exception e) {
        System.out.println(e.getMessage());
        return false;
    }
}