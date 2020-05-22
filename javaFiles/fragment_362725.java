@Component("endpointConfigurer")
public class TemplateEndpointConfigurer implements CxfEndpointConfigurer {

    @Override
    public void configure(AbstractWSDLBasedEndpointFactory factoryBean) {
        // Do nothing here
    }

    @Override
    public void configureClient(Client client) {

        final HTTPConduit conduit = (HTTPConduit) client.getConduit();

        final HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(webServiceConnectionTimeout);
        policy.setReceiveTimeout(webServiceReadTimeout);
        policy.setConnection(ConnectionType.CLOSE);
        conduit.setClient(policy);

    }

    @Override
    public void configureServer(Server server) {
        // Do nothing here
    }
}