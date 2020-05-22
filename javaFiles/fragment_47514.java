@Component
public class MyRouteDefinition extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        KeyStoreParameters ksp = new KeyStoreParameters();
        ksp.setType("pkcs12");
        ksp.setResource(PushRoutesDefinition.class.getResource("/keystore.p12").getPath());
        ksp.setPassword("password");

        KeyManagersParameters kmp = new KeyManagersParameters();
        kmp.setKeyStore(ksp);
        kmp.setKeyPassword("password");

        TrustManagersParameters trustManagersParameters = new TrustManagersParameters();
        trustManagersParameters.setKeyStore(ksp);

        SSLContextParameters scp = new SSLContextParameters();
        scp.setKeyManagers(kmp);
        scp.setTrustManagers(trustManagersParameters);

        HttpComponent httpComponent = getContext().getComponent("https4", HttpComponent.class);
        httpComponent.setSslContextParameters(scp);

        //TO HTTPS
        from(...)
        .to("https4://localhost:8080/load")
        .process(exchange -> {
                    Integer responseCode = 
             exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class);
             log.debug("The response code is: {}", responseCode);
         }
    }