HTTP2Client client = new HTTP2Client();
client.start();

FuturePromise<Session> sessionPromise = new FuturePromise<>();
client.connect(new InetSocketAddress(host, port), new ServerSessionListener.Adapter() {
    @Override
    public void onPing(Session session, PingFrame frame) {
        // The other peer replies to our pings.
    }
}, sessionPromise);
Session session = sessionPromise.get(5, TimeUnit.SECONDS);

session.ping(new PingFrame(System.nanoTime(), false), Callback.NOOP);