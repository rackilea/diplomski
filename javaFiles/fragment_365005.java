class ConnectionObserver {

    private List<DbConnection> connections;
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void closeConnection(int id) {
        final Lock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        try {
            for (Iterator<DbConnection> it = connections.iterator(); it.hasNext();) {
                DbConnection conn = it.next();
                if (conn.getId() == id) {
                    conn.close();
                    it.remove();
                }
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
            for (DbConnection conn : connections) {
                if (conn.isOpen()) {
                    ++open;
                }
            }
        } finally {
            readLock.unlock();
        }
        return open;
    }
    // more synchronized methods which alter the list via iterators
}