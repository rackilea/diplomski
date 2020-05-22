private Map<Integer, DbConnection> connections;

    public void closeConnection(int id) {
        final Lock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        try {
            final DbConnection dbConnection = connections.remove(id);
            if (dbConnection == null) {
                //handle invalid remove attempt
            } else {
                dbConnection.close();
            }
        } finally {
            writeLock.unlock();
        }
    } 

    public int countOpenConnections() {
        int open = 0;
        final Lock readLock = readWriteLock.readLock();
        readLock.lock();
        try {
            for (final DbConnection conn : connections.values()) {
                if (conn.isOpen()) {
                    ++open;
                }
            }
        } finally {
            readLock.unlock();
        }
        return open;
    }