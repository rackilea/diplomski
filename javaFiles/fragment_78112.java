public class MyApplicationClass {
    // Inject an instance of the service's port-type.
    @WebServiceRef(EchoService.class)
    private EchoPortType port;

    // This method will invoke  the web service operation and send transport headers on the request.
    public void invokeService() {

        // Set up the Map that will contain the request headers.
        Map<String, Object> requestHeaders = new HashMap<String, Object>();
        requestHeaders.put(“MyHeader1”, “This is a string value”);
        requestHeaders.put(“MyHeader2”, new Integer(33));
        requestHeaders.put(“MyHeader3”, new Boolean(true));

        // Set the Map as a property on the RequestContext.
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(com.ibm.websphere.webservices.Constants.REQUEST_TRANSPORT_PROPERTIES, requestHeaders);

        // Invoke the web services operation.
        String result = port.echoString(“Hello, world!”);
    }
}