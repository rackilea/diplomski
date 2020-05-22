public static void main(String[] args) throws Exception {
    Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:~/swdev/hsqldb/testdb", "SA", "");
    PreparedStatement statement = connection.prepareCall("create text TABLE data_source (id INTEGER)");
    statement.execute();
    statement.close();
    statement = connection.prepareCall("set TABLE data_source source 'data.csv;ignore_first=true;fs=\\\\semi'");
    statement.execute();
    statement.close();
    connection.close();
}