@Configuration
public class SoapClientConfig {

    @Bean
    public KeyStoreCallbackHandler securityCallbackHandler() throws Exception {
        KeyStoreCallbackHandler callbackHandler = new KeyStoreCallbackHandler();
        callbackHandler.setSymmetricKeyPassword("serverPassword");
        return callbackHandler;
    }

    @Bean
    public Wss4jSecurityInterceptor securityInterceptor() throws IOException, Exception {

        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();

        // set security actions
        securityInterceptor.setSecurementActions("Timestamp Signature");
        securityInterceptor.setSecurementUsername("clientAias");
        securityInterceptor.setSecurementPassword("clientPassword");

        //sign both body and timestamp - default body will be signed
        securityInterceptor.setSecurementSignatureParts("{}{http://schemas.xmlsoap.org/soap/envelope/}Body;{}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp");

        //This will generate binarySecurityToken in header
        securityInterceptor.setSecurementSignatureKeyIdentifier("DirectReference");
        securityInterceptor.setSecurementSignatureCrypto(getRequestCryptoBean().getObject());

        return securityInterceptor;
    }

    @Bean
    public CryptoFactoryBean getRequestCryptoBean() throws IOException {

        CryptoFactoryBean cryptoFactoryBean = new CryptoFactoryBean();
        cryptoFactoryBean.setKeyStorePassword("clientPassword");
        cryptoFactoryBean.setKeyStoreLocation("clientCertLoc");
        return cryptoFactoryBean;
    }

    @Bean
    public Wss4jSecurityInterceptor responseSecurityInterceptor() throws IOException, Exception {

        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setValidationActions("Timestamp Signature");
        securityInterceptor.setValidationSignatureCrypto(getResponseCryptoBean().getObject());
        securityInterceptor.setValidationCallbackHandler(securityCallbackHandler());

        return securityInterceptor;
    }

    @Bean
    public CryptoFactoryBean getResponseCryptoBean() throws Exception {

        CryptoFactoryBean cryptoFactoryBean = new CryptoFactoryBean();
        cryptoFactoryBean.setKeyStoreLocation("serverCertLoc");
        cryptoFactoryBean.setDefaultX509Alias("serverAlias");
        cryptoFactoryBean.setKeyStorePassword("serverPassword");
        cryptoFactoryBean.afterPropertiesSet();
        return cryptoFactoryBean;
    }

    @Bean
    public Jaxb2Marshaller getMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(generatedResource);
        return marshaller;
    }

    @Bean
    public WebServiceClass getPojoClassMethod() throws ConnectException, Exception {

        WebServiceClass pClass= new WebServiceClass();
        pClass.setMarshaller(getMarshaller());
        pClass.setUnmarshaller(getMarshaller());

        //Set timeout for soap service
        HttpComponentsMessageSender sender = new HttpComponentsMessageSender();
        int timeout;
        if (null == stringFromEnvironmentOrIllegalStateException(env, timeoutInMs)) {
            timeout = 10000;
        } else {
            timeout = Integer.parseInt(stringFromEnvironmentOrIllegalStateException(env, timeoutInMs));
        }
        sender.setConnectionTimeout(timeout);
        sender.setReadTimeout(timeout);
        pClass.setMessageSender(sender);
        //end timeout config

        pClass.setDefaultUri("actionURL");
        ClientInterceptor[] interceptors = new ClientInterceptor[]{securityInterceptor(), responseSecurityInterceptor()};
        pClass.setInterceptors(interceptors);

        return pClass;
    }

}