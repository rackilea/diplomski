private int id;
private transient java.sql.Connection connection;

private void readObject(ObjectOutputStream out) throws IOException {
    out.defaultReadObject();
    connection = DriverManager.getConnection();
}