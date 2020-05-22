ERROR [org.jboss.ws.core.CommonClient] (ajp-10.1.75.243-8109-4) Exception caught while (preparing for) performing the invocation:
javax.xml.ws.soap.SOAPFaultException: Unqualified {http://schemas.xmlsoap.org/soap/envelope/}Client fault
    at org.jboss.ws.core.jaxws.SOAPFaultHelperJAXWS.getSOAPFaultException(SOAPFaultHelperJAXWS.java:85)
    at org.jboss.ws.core.jaxws.binding.SOAP11BindingJAXWS.throwFaultException(SOAP11BindingJAXWS.java:107)
    at org.jboss.ws.core.CommonSOAPBinding.unbindResponseMessage(CommonSOAPBinding.java:558)
    at org.jboss.ws.core.CommonClient.invoke(CommonClient.java:396)
    at org.jboss.ws.core.jaxws.client.ClientImpl.invoke(ClientImpl.java:231)
    at org.jboss.ws.core.jaxws.client.ClientProxy.invoke(ClientProxy.java:171)
    at org.jboss.ws.core.jaxws.client.ClientProxy.invoke(ClientProxy.java:157)