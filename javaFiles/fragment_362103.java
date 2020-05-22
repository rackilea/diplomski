Connection connection = DriverManager.getConnection(url,dbUserName,dbPassword);

StringBuffer stringBuffer = new StringBuffer("SELECT * FROM TABLEx");
LoggableStatement statement = new LoggableStatement(connection,stringBuffer.toString());

try {
    statement.execute();
} catch (Exception ex) {
    // write QueryString to a file!
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fileName", true), "cp1256"));
    out.write(statement.getQueryString());
    out.close();
} finally {
    if (statement != null && !statement.isClosed()) {
        statement.close();
    }
}