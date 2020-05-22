public DBConnection() {
    try
    {
        conn = DriverManager.getConnection(this.url, "test", "test");
        st = conn.createStatement();

    }
    catch (SQLException ex)
    {
       System.out.print("SQL EXCEPTION");
    }
}