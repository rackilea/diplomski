/**
 * Close the given  ResultSet and ignore any thrown exception.
 * This is useful for typical finally blocks in manual  code.
 * @param resultSet the  ResultSet to close
 * @see javax.resource.cci.ResultSet#close()
 */
private void closeResultSet(ResultSet resultSet) {
  if (resultSet != null) {
    try {
      resultSet.close();
    }
    catch (SQLException ex) {
      logger.debug("Could not close  ResultSet", ex);
    }
    catch (Throwable ex) {
      // We don't trust the  driver: It might throw RuntimeException or Error.
      logger.debug("Unexpected exception on closing  ResultSet", ex);
    }
  }
}