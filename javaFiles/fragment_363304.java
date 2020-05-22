import java.io.ByteArrayInputStream;
 import java.security.KeyStore;
 import java.util.Arrays;
 import java.util.List;

 import javax.jws.WebService;
 import javax.net.ssl.KeyManagerFactory;
 import javax.net.ssl.SSLContext;

 import org.apache.cxf.configuration.jsse.TLSServerParameters;
 import org.apache.cxf.configuration.security.ClientAuthentication;
 import org.apache.cxf.configuration.security.FiltersType;
 import org.apache.cxf.endpoint.Endpoint;
 import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
 import org.apache.cxf.transport.http_jetty.JettyHTTPServerEngineFactory;

 public class Server extends Thread {

    private boolean             isRunning   = false;

    @WebService(name = "SoapService", serviceName = "SoapService", endpointInterface = "playground.mstahl.cxf_soap.SoapServiceDefinition")
    private static final class ServerImpl implements SoapServiceDefinition {

        @Override
        public String sayHelloToMe(String caller) throws Exception {
            return "oh Hello " + caller + ".";
        }

        @Override
        public String askFunctionality() throws Exception {
            return "Well, as I am answering I guess its working...duh";
        }

        @Override
        public String sayGoodbyeToMe(String caller) throws Exception {
            return "Goodbye doucheb...i mean..." + caller + ".";
        }

    }

    private final int       usedPort;
    private final byte[]    storeBytes;
    private final char[]    storePass;
    private final char[]    entryPass;
    private final boolean   sslEnabled;

    public Server(int port, boolean sslEnabled, byte[] storeBytes, char[] storePass, char[] entryPass) {
        super("CXF-SOAP-Playground");
        setDaemon(true);
        usedPort = port;
        this.sslEnabled = sslEnabled;
        this.storeBytes = storeBytes;
        this.storePass = storePass;
        this.entryPass = entryPass;
        start();
    }

    @Override
    public void run() {

        System.out.println("  ... creating factory.");
        JaxWsServerFactoryBean sf = new JaxWsServerFactoryBean();

        System.out.println("  ... setting address and implementing service.");
        sf.setAddress(String.format("http" + (sslEnabled ? "s" : "") + "://localhost:%d/signtest/", Integer.valueOf(usedPort)));
        sf.setServiceClass(ServerImpl.class);

        System.out.println("  ... setting up service bean.");
        ServerImpl serviceBean = new ServerImpl();
        sf.setServiceBean(serviceBean);

        if (sslEnabled) {

            try {
                JettyHTTPServerEngineFactory factory = sf.getBus().getExtension(JettyHTTPServerEngineFactory.class);
                factory.setTLSServerParametersForPort(usedPort, getTLSServerParameters());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        System.out.println("  ... starting actual SOAP-server.");
        org.apache.cxf.endpoint.Server server = sf.create();

        Endpoint endpoint = server.getEndpoint();
        String endpointAddr = endpoint.getEndpointInfo().getAddress();

        System.out.println("Server started at " + endpointAddr);

        if (!server.isStarted()) {
            return;
        }

        isRunning = true;
        System.out.println("... done.");
        while (!isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }

        System.out.println("... stopping actual SOAP-server.");
        server.stop();
        System.out.println("... destroying its remnants.");
        server.destroy();
    }

    public boolean isRunning() {
        return isRunning;
    }

    private final TLSServerParameters getTLSServerParameters() {
        TLSServerParameters tlsParams = null;
        try {

            // 1 - Load key store
            KeyStore localKeyStore = KeyStore.getInstance("PKCS12");
            localKeyStore.load(new ByteArrayInputStream(storeBytes), storePass);

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(localKeyStore, entryPass);

            // 2 - Add the new keyManager to the tls settings. 
            tlsParams = new TLSServerParameters();
            tlsParams.setKeyManagers(kmf.getKeyManagers());

            // 3 - Adjust cipher suite filters
            final List<String> cipherSuites = Arrays.asList(SSLContext.getDefault().getSocketFactory().getSupportedCipherSuites());
            System.out.println(String.format("Suppored cipher suites : %s", cipherSuites.toString()));

            final FiltersType filter = new FiltersType();
            final List<String> include = filter.getInclude();

            include.add(".*");
            include.add(".*_EXPORT1024_.*");
            include.add(".*_WITH_DES_.*");
            include.add(".*_WITH_AES_.*");
            include.add(".*_WITH_NULL_.*");
            include.add(".*_RSA_WITH_AES_.*");
            include.add(".*_DH_anon_.*");

            tlsParams.setCipherSuitesFilter(filter);

            // 4 - Disable client authentication
            final ClientAuthentication ca = new ClientAuthentication();
            ca.setRequired(false);
            ca.setWant(false);
            tlsParams.setClientAuthentication(ca);

        } catch (final Exception e) {
            e.printStackTrace();
            System.err.println("Security configuration failed with the following: " + e.getMessage() + " " + e.getCause());
            tlsParams = null;
        }

        return tlsParams;
    }

 }