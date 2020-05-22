/**
 * Insert to database using JDBC 3.0 + which will return the key of the new row.
 * 
 * @param sql is the sql insert to send to the database
 * @return the key for the inserted row
 * @throws DBSQLException
 */
public static int insertAndReturnKey(Connection dbConnection, String sql, List<SqlField> params) throws DBSQLException
{

    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String paramList = null;
    try {
        preparedStatement = dbConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        // Setup your parameters
        int result = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            return (resultSet.getInt(1));
        } else {
            // throw an exception from here
            throw new SQLException("Failed to get GeneratedKey for [" + sql + "]");
        }
    } catch (SQLException ex) {
        throw new DBSQLException(buildErrorMessage(ex, sql, params));
    } finally {
        DBConnector.closeQuietly(preparedStatement);
        DBConnector.closeQuietly(resultSet);
    }
}