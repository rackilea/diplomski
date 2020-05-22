public Connection getConnection() throws SQLException {
        long max = System.currentTimeMillis() + timeout * 1000;
        do {
              synchronized (this){
                if (activeConnections < maxConnections) {
                    return getConnectionNow();
                }
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    // ignore
                }
            }
        } while (System.currentTimeMillis() <= max);
        throw new SQLException("Login timeout", "08001", 8001);
    }