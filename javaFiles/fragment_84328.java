JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean = new JaxWsPortProxyFactoryBean();
String URI = "http://localhost:8080/service";
try {

    jaxWsPortProxyFactoryBean.setWsdlDocumentUrl(new URL(URI+"?wsdl"));
    jaxWsPortProxyFactoryBean.setServiceInterface(myIService.class);
    jaxWsPortProxyFactoryBean.setPortName(PORT);
    jaxWsPortProxyFactoryBean.setNamespaceUri(URI);
    jaxWsPortProxyFactoryBean.setServiceName(SERVICE_NAME);
    logger.debug("WSDL - "+jaxWsPortProxyFactoryBean.getWsdlDocumentUrl());
    jaxWsPortProxyFactoryBean.afterPropertiesSet();

} catch (Exception e) {
    logger.error("Error occured while connecting to the TW web service -",e);
}