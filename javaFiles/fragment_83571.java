public class MyApplication extends Application {
    public MyApplication() {
        getTunnelService().setExtensionsTunnel(true);
    }

    @Override
    public Restlet createInboundRoot() {
        (...)
    }
}