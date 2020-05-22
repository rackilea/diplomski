try (Connection connection = Connector()) {
    ...
    pst.executeUpdate();
} catch (SQLiteException ex) {
    if (ex.getResultCode() == SQLiteErrorCode.SQLITE_CONSTRAINT_UNIQUE) {
        System.out.println("Username already in use!");
    } else {
        ex.printStackTrace(); // unexpected exception
    }
} catch (SQLException ex) {
    ex.printStackTrace(); // unexpected exception
}