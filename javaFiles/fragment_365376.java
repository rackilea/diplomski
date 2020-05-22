Connection createConnection(String configFilePath) {
    Properties connectionProperties = loadPropertiesFromFile(configFilePath);
    try {
        Class driverClass = Class.forName(connectionProperties.getProperty(JDBC_DRIVER_PROPERTY));
        LOG.log(Level.INFO, "Driver loaded: {0}", driverClass);
    } catch (ClassNotFoundException ex) {
        LOG.log(Level.SEVERE, "Driver not found”, ex);
    }

    try {
        Connection connection = DriverManager.getConnection(
            connectionProperties.getProperty(JDBC_URL_PROPERTY),
            connectionProperties.getProperty(JDBC_USER_PROPERTY),
            connectionProperties.getProperty(JDBC_PASSWORD_PROPERTY))
        LOG.log(Level.INFO, “Connection created: {0}", connection);
        return connection;
    } catch (SQLException ex) {
        LOG.log(Level.SEVERE, “Unable to connect to DB”, ex);
        return null;
    }
}