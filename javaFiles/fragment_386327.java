@Override
public void contextDestroyed(ServletContextEvent servletContextEvent) {
    try {
        connection = dataSource.getConnection(); //Your dataSource (I obtain it from Guice)
    } catch (SQLException ex) {
    } finally {
        try {
            if (connection != null) {
                connection.close();
            }
            if (dataSource != null) {
                try {
                    DataSources.destroy(dataSource);
                    dataSource = null;
                } catch (Exception e) {
                }
            }
        } catch (SQLException sQLException) {
            XLog.error(sQLException);
        }
    }
}