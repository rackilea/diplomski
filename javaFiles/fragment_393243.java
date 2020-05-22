public class CBridgeApp implements BundleActivator {
    private EchoServer method;
    public void start(BundleContext bc) throws Exception {
        ...

        method = new EchoServer();
        method.start();
    }
    public void stop(BundleContext bc) throws Exception {
        ...

        method.stop();
    }
}