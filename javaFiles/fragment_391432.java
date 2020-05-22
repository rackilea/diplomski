@Test
public void getPrimaryKeys() throws Exception {
    DatabaseMetaData databaseMetaData = null;
    ResultSet rs = null;
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smu_teachers_corp?" +
                    "autoReconnect=true&allowMultiQueries=true&useSSL=false&createDatabaseIfNotExist=false&allowPublicKeyRetrieval=true",
            "smu_root", "smu_root_password");
    try {
        databaseMetaData = connection.getMetaData();
        rs = databaseMetaData.getPrimaryKeys(null, null, "user_accounts");
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        while (rs.next()) {
            System.out.println(rs.getString("COLUMN_NAME"));
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.println("Label: " + resultSetMetaData.getColumnLabel(i) + "  Value:" + rs.getString(i));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}