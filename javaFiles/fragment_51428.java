class MeasuringClientConnManager extends SingleClientConnManager {
    private long mReceivedBytes = -1;
    private long mSentBytes = -1;
    public MeasuringClientConnManager(HttpParams params, SchemeRegistry schreg) {
        super(params, schreg);
    }
    @Override
    public void releaseConnection(ManagedClientConnection conn,
            long validDuration, TimeUnit timeUnit) {
        HttpConnectionMetrics metrics = conn.getMetrics();
        mReceivedBytes = metrics.getReceivedBytesCount();
        mSentBytes = metrics.getSentBytesCount();
        metrics.reset();
        super.releaseConnection(conn, validDuration, timeUnit);
    }

    public long getReceivedBytes() {
        return mReceivedBytes;
    }
    public long getSentBytes() {
        return mSentBytes;
    }
}