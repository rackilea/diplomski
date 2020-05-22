Connection connection = dataSource.getConnection();
try {
    PreparedStatement statement = connection.prepareStatement();
    try {
        // Work with the statement
    catch (SQLException e ) {
        // Handle exceptions
} catch (SQLException e {
    // Handle exceptions
    } finally {
        statement.close();
    }
} finally {
    connection.close();
}