@WebService
public class EchoServiceImpl implements EchoServicePortType {

    // Inject an instance of WebServiceContext so we can retrieve
    // the MessageContext for each invocation of this endpoint.
    @Resource
    WebServiceContext ctxt;

    /**
     * Default constructor.
     */
    public EchoServiceImpl() {
        ....
    }

    public String echoString(String input) {
        String result = “Echo result: “ + input;

        // Retrieve the MessageContext from the injected WebServiceContext.
        MessageContext mc = ctxt.getMessageContext();

        // Send some headers back in the response message.
        Map<String, Object> responseHeaders = new HashMap<String, Object>();
        responseHeaders.put("MyHeader1", "This is a string response value");
        responseHeaders.put("MyHeader2", new Integer(33));
        responseHeaders.put("MyHeader3”, new Boolean(false));

        // Set the response header Map on the MessageContext.
        mc.put(com.ibm.websphere.webservices.Constants.RESPONSE_TRANSPORT_PROPERTIES, responseHeaders);

        return result;
    }
}