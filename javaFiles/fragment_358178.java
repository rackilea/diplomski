public class AddValuesFaultInterceptor extends AbstractSoapInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AddValuesFaultInterceptor.class);

    public AddValuesFaultInterceptor() {
        super(Phase.MARSHAL);
    }

    public void handleMessage(SoapMessage soapMessage) throws Fault {
        Fault fault = (Fault) soapMessage.getContent(Exception.class);

        if (fault.getCause() instanceof org.mule.api.transformer.TransformerMessagingException) {           
            Element detail = fault.getOrCreateDetail();
            Element errorDetail = detail.getOwnerDocument().createElement("addValuesError");
            Element errorCode = errorDetail.getOwnerDocument().createElement("errorCode");
            Element message = errorDetail.getOwnerDocument().createElement("message");
            errorCode.setTextContent("400");
            message.setTextContent("BAD REQUEST");
            errorDetail.appendChild(errorCode);
            errorDetail.appendChild(message);
            detail.appendChild(errorDetail);
        }
    }
    private Throwable getOriginalCause(Throwable t) {
        if (t instanceof ComponentException && t.getCause() != null) {
            return t.getCause();
        } else {
            return t;
        }
    }
}