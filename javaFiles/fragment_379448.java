if (compare(CLOSE_VAL,method)) {
    if (connection==null) return null; //noop for already closed.
        PooledConnection poolc = this.connection;
        this.connection = null;
        pool.returnConnection(poolc);
        return null;
    } 
}