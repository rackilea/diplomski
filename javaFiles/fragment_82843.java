Connection connection = null;
  try {
    connection = ... // Get database connection
    // Use connection -- may throw exceptions
  } finally {
    close(connection);
  }

private void close(Connection connection) {
  try {
    if (connection != null) {
      connection.close(); // This can also throw an exception
    }
  } catch (Exception e) {
    // log something
    throw new RuntimeException(e); // or an application specific runtimeexception
  }
}