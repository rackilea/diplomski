private String mSQL = "select count(1) from t\n";

private void foo()
{
    Connection con = getJDBCConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next())
    {
        int n = rs.getInt("anzahl");
        System.out.println(n);
    }
    stmt.close();
    con.close();
}