/**
 * Set a parameter to a java.sql.Timestamp value. The driver converts this
 * to a SQL TIMESTAMP value when it sends it to the database.
 *
 * @param parameterIndex the first parameter is 1...
 * @param x the parameter value
 *
 * @throws SQLException if a database access error occurs
 */
public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
    setTimestampInternal(parameterIndex, x, this.connection.getDefaultTimeZone());
}

/**
 * Set a parameter to a java.sql.Timestamp value. The driver converts this
 * to a SQL TIMESTAMP value when it sends it to the database.
 *
 * @param parameterIndex the first parameter is 1, the second is 2, ...
 * @param x the parameter value
 * @param cal the calendar specifying the timezone to use
 *
 * @throws SQLException if a database-access error occurs.
 */
public void setTimestamp(int parameterIndex, java.sql.Timestamp x,Calendar cal) throws SQLException {
    setTimestampInternal(parameterIndex, x, cal.getTimeZone());
}