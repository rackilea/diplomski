public class WildCoapServer extends CoapServer {

    private static final int COAP_PORT = NetworkConfig.getStandard  ().getInt  (NetworkConfig.Keys.COAP_PORT);

    public WildCoapServer () throws Exception {

        // add endpoints on all IP addresses
        addEndpoints ();

        ResourcesLoader resLoader   = new ResourcesLoader ();
        List<ProxyRes> resources    = resLoader.getResourcesList ();

        setMessageDeliverer (new DynamicMessageDeliverer (resources));
    }

    @Override
    protected Resource createRoot () {
        return new WildRootResource ();
    }

    // Add individual endpoints listening on default CoAP port on all IPv4 addresses of all network interfaces.
    private void addEndpoints () {
        for (InetAddress addr : EndpointManager.getEndpointManager ().getNetworkInterfaces ()) {
            // only binds to IPv4 addresses and localhost
            if (addr instanceof Inet4Address || addr.isLoopbackAddress ()) {
                InetSocketAddress bindToAddress = new InetSocketAddress (addr, COAP_PORT);
                addEndpoint (new CoapEndpoint (bindToAddress));
            }
        }
    }
}