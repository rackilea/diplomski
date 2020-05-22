import javax.xml.rpc.handler.GenericHandler;

public class TestResponseHandler extends GenericHandler {
    private static final String XSD_UR_TYPE = "xsd:ur-type";
    private static final String XSD_ANY_TYPE = "xsd:anyType";
    private static final String XSD_INT_ARRAY = "xsd:int[";
    private static final String XSD_ANY_TYPE_ARRAY = "xsd:anyType[";

    @Override
    public boolean handleResponse(MessageContext context) {
        SOAPMessageContext smc = (SOAPMessageContext) context;
        SOAPMessage sm = smc.getMessage();
        try {
            SOAPBody sb = sm.getSOAPBody();
            handleNodes(sb.getElementsByTagName("problemTag"));
            sm.saveChanges();
        } catch (Exception e) {
            // ...
        }

        return super.handleResponse(context);
    }

    private void handleNodes(NodeList nodes) {
        // do your search and replace here
        if (nodes == null) {
            return;
        }
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            NamedNodeMap attributes = node.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                Node attribute = attributes.item(j);
                if (attribute.getNodeValue().startsWith(XSD_UR_TYPE)) {
                    attribute.setNodeValue(attribute.getNodeValue().replace(XSD_UR_TYPE, XSD_ANY_TYPE));
                } else if (attribute.getNodeValue().startsWith(XSD_INT_ARRAY)) {
                    attribute.setNodeValue(attribute.getNodeValue().replace(XSD_INT_ARRAY, XSD_ANY_TYPE_ARRAY));
                }
            }
        }
    }

}