public class ConnectionPool {
    private HikariDataSource hds;
    private ReentrantReadWriteLock dsLock = ....;
    //....

    public void reloadFile() {
        dsLock.writeLock().lock();
        try {
            if (hds != null) {
                hds.close();
            }

            hds = new HikariDataSource(new HikariConfig(propertyFileName));
        } finally {
            dsLock.writeLock().unlock();
        }
    }

    public void executeQuery(final String sql, final CallBack<ResultSet, SQLException> callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;

                dsLock.readLock().lock();
                try {
                    connection = hds.getConnection();
                    // ....
                } catch (SQLException e) {
                    callBack.call(null, e);
                } finally {
                    // your other cleanups
                    dsLock.readLock().unlock();
                }
            }
        }).start();
    }
    //....
}