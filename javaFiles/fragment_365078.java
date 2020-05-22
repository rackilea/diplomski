String connectionUrl = "jdbc:sqlserver://localhost:52865;"
        + "databaseName=myDb;" + "integratedSecurity=true";
try (Connection con = DriverManager.getConnection(connectionUrl)) {
    System.out.println(String.format(
            "getCatalog() returns: %s", 
            con.getCatalog()));
    try (Statement s = con.createStatement()) {
        System.out.println("           Executing: USE master");
        s.execute("USE master");
    }
    System.out.println(String.format(
            "getCatalog() returns: %s", 
            con.getCatalog()));
} catch (Exception e) {
    e.printStackTrace(System.out);
}