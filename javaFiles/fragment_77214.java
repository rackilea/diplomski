private void addUsernameTokenProfile(WebService webServicePort, String username, String password) {
    try
    {
        final String SECURITY_NAMESPACE =
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";

        SOAPFactory soapFactory = SOAPFactory.newInstance();
        QName securityQName = new QName(SECURITY_NAMESPACE, "Security");
        SOAPElement security = soapFactory.createElement(securityQName);
        QName tokenQName = new QName(SECURITY_NAMESPACE, "UsernameToken");
        SOAPElement token = soapFactory.createElement(tokenQName);
        QName userQName = new QName(SECURITY_NAMESPACE, "Username");
        SOAPElement soapUsername = soapFactory.createElement(userQName);
        soapUsername.addTextNode(username);
        QName passwordQName = new QName(SECURITY_NAMESPACE, "Password");
        SOAPElement soapPassword = soapFactory.createElement(passwordQName);
        soapPassword.addTextNode(password);
        token.addChildElement(soapUsername);
        token.addChildElement(soapPassword);
        security.addChildElement(token);
        Header header = Headers.create(security);
        ((WSBindingProvider) webServicePort).setOutboundHeaders(header);
}}