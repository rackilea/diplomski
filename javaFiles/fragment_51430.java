class MeasuringClientConnManager extends SingleClientConnManager {

    interface WireListener {
        void onUpdate(long sent, long recv);
    }
    private WireListener mListener;
    private long mReceivedBytes = -1;
    private long mSentBytes = -1;
    private Wire mWire = new Wire(null) {
        public boolean enabled() { return true; };
        // Time to override a bunch of methods (otherwise Wire will crash)
        public void input(byte[] b) throws IOException {mReceivedBytes += b.length; rxtx();};
        public void input(byte[] b, int off, int len) throws IOException {mReceivedBytes += len; rxtx();}
        public void input(InputStream instream) throws IOException {mReceivedBytes += count(instream); rxtx();}
        public void input(String s) throws IOException {mReceivedBytes += s.length(); rxtx();};
        public void input(int b) throws IOException {mReceivedBytes++; rxtx();}
        public void output(byte[] b) throws IOException {mSentBytes += b.length; rxtx();}
        public void output(byte[] b, int off, int len) throws IOException {mSentBytes += len; rxtx();}
        public void output(int b) throws IOException {mSentBytes++; rxtx();}
        public void output(String s) throws IOException {mSentBytes += s.length(); rxtx();}
        public void output(InputStream outstream) throws IOException {mSentBytes += count(outstream); rxtx();};

        private int count(InputStream is) throws IOException {
            int result = 0;
            byte[] b = new byte[1024 * 8];
            int count;
            while ((count = is.read(b)) > -1) {
                result += count;
            }
            return result;
        }
    };

    public MeasuringClientConnManager(HttpParams params, SchemeRegistry schreg) {
        super(params, schreg);
    }

    public void setWireListener(WireListener wl) {
        mListener = wl;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ClientConnectionOperator createConnectionOperator(
            SchemeRegistry schreg) {
        final ClientConnectionOperator actual = super.createConnectionOperator(schreg);
        ClientConnectionOperator wired = new ClientConnectionOperator() {
            @Override
            public void updateSecureConnection(OperatedClientConnection conn,
                    HttpHost target, HttpContext context, HttpParams params)
                    throws IOException {
                actual.updateSecureConnection(conn, target, context, params);
            }
            @Override
            public void openConnection(OperatedClientConnection conn, HttpHost target,
                    InetAddress local, HttpContext context, HttpParams params)
                    throws IOException {
                actual.openConnection(conn, target, local, context, params);
            }

            @Override
            public OperatedClientConnection createConnection() {
                DefaultClientConnection conn = new DefaultClientConnection() {
                    @Override
                    protected SessionInputBuffer createSessionInputBuffer(
                            Socket socket, int buffersize, HttpParams params)
                            throws IOException {
                        return new LoggingSessionInputBuffer(super.createSessionInputBuffer(socket, buffersize, params), mWire);
                    }
                    @Override
                    protected SessionOutputBuffer createSessionOutputBuffer(
                            Socket socket, int buffersize, HttpParams params)
                            throws IOException {
                        return new LoggingSessionOutputBuffer(super.createSessionOutputBuffer(socket, buffersize, params), mWire);
                    }
                };
                return conn;
            }
        };
        return wired;
    }

    void rxtx() {
        WireListener l = mListener;
        if (l != null) {
            l.onUpdate(mSentBytes, mReceivedBytes);
        }
    }
}