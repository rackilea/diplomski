private boolean doNotLog=false;

public void handleMessage(Message message) throws Fault {
    TreeMap<String,List> protocolHeaders =
            (TreeMap<String, List>) message.get("org.apache.cxf.message.Message.PROTOCOL_HEADERS");
    if (protocolHeaders != null) {
        List value = protocolHeaders.get("SOAPAction");
        String soapAction = value != null ? (String)value.get(0) : "";
        if (soapAction.equalIgnoreCase(YOUR_SERVICE_SOAP_ACTION)) {
            doNotLog=true;
        }
    }
    super.handleMessage(message);
}