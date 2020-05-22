/**
 * The returned stream must be closed.
 */
public Stream<Row> query(String sql){
    Connection c = dataSource.openConnection();
    return MyDB.query(sql).stream().onClose(() -> {
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    });
}