String connectionUrl = "jdbc:sqlserver://localhost:52865;"
        + "databaseName=myDb;" + "integratedSecurity=true";
try (Connection conn = DriverManager.getConnection(connectionUrl)) {
    try (CallableStatement cs = conn.prepareCall("{call Table1sp}")) {
        cs.execute();
        ResultSet rs = cs.getResultSet();
        rs.next();
        System.out.println(rs.getInt(1));
        rs.close();
    }
} catch (Exception e) {
    e.printStackTrace(System.err);
}