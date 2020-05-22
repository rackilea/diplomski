private YourService proxy;

public YourServiceWrapper() {
    try {
        final String username = "username";
        final String password = "password";
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        username,
                        password.toCharArray());
            }
        });
        URL url = new URL("http://yourserviceurl/YourService?WSDL");
        QName qname = new QName("http://targetnamespace/of/your/wsdl", "YourServiceNameInWsdl");
        Service service = Service.create(url, qname);
        proxy = service.getPort(YourService.class);
        Map<String, Object> requestContext = ((BindingProvider) proxy).getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url.toString());
        requestContext.put(BindingProvider.USERNAME_PROPERTY, username);
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, password);
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
    } catch (Exception e) {
        LOGGER.error("Error occurred in web service client initialization", e);
    }
}