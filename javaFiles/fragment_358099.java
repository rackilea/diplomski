@Override
public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    ConnectionSource cs = getConnectionSource();
    /*
     * The method is called by Android database helper's get-database calls when Android detects that we need to
     * create or update the database. So we have to use the database argument and save a connection to it on the
     * AndroidConnectionSource, otherwise it will go recursive if the subclass calls getConnectionSource().
     */
    DatabaseConnection conn = cs.getSpecialConnection();
    boolean clearSpecial = false;
    if (conn == null) {
        conn = new AndroidDatabaseConnection(db, true);
        try {
            cs.saveSpecialConnection(conn);
            clearSpecial = true;
        } catch (SQLException e) {
            throw new IllegalStateException("Could not save special connection", e);
        }
    }
    try {
        dropTables(cs);
        createTables(cs);
    } catch (SQLException e) {
        // log something
    } finally {
        if (clearSpecial) {
            cs.clearSpecialConnection(conn);
        }
    }
}

private void createTables(ConnectionSource connectionSource) throws SQLException {
    TableUtils.createTable(connectionSource, YourTableObject.class);
}

public void dropTables(ConnectionSource connectionSource) throws SQLException{
    TableUtils.dropTable(connectionSource, YourTableObject.class, true);
}