public class RequestResponseHandler  implements SOAPHandler<SOAPMessageContext> {

    private static Logger log = Logger.getLogger(RequestResponseHandler.class);
    private Transformer transformer = null;
    private DocumentBuilderFactory docBuilderFactory = null;
    private DocumentBuilder docBuilder = null;

    public RequestResponseHandler() {
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();
        } catch (TransformerConfigurationException
                | TransformerFactoryConfigurationError
                | ParserConfigurationException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void close(MessageContext arg0) {
    }

    @Override
    public boolean handleFault(SOAPMessageContext messageContext) {
        log(messageContext);
        return true;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext messageContext) {
        log(messageContext);
        return true;
    }

    private void log(SOAPMessageContext messageContext) {
        String xml = "";
        SOAPMessage msg = messageContext.getMessage();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            msg.writeTo(out);
            xml = out.toString("UTF-8");
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }       

        String direction = "";
        Boolean outbound = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY); 
        if (outbound) { 
            direction += "Request: \n"; 
        } else { 
            direction += "Response: \n";
        } 

        log.info(direction + getXMLprettyPrinted(xml));     
    }

    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }


    public String getXMLprettyPrinted(String xml) {

        if (transformer == null || docBuilder == null)
            return xml;

        InputSource ipXML = new InputSource(new StringReader(xml));
        Document doc;

        try {
            doc = docBuilder.parse(ipXML);
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            DOMSource domSource = new DOMSource(doc);
            transformer.transform(domSource, streamResult);
            return stringWriter.toString();
        } catch (SAXException | IOException | TransformerException e) {
            log.error(e.getMessage(), e);
            return xml;
        }
    }
}