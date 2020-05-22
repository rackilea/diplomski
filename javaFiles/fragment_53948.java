// Set the connection up with jdbc and sqlite.
Connection connection = DriverManager.getConnection("jdbc:sqlite:file.db");

// Get the tables.
DatabaseMetaData dbmd = connection.getMetaData();
ResultSet trs = dbmd.getTables(null, null, "%", null);
while (trs.next()) {
            String tblname = trs.getString("TABLE_NAME").toLowerCase();
            log.log(Level.INFO, "Found table: " + tblname);
}