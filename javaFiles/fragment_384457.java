public class FixNamespaceHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public void close(MessageContext arg0) {
        // Do nothing
    }

    @Override
    public boolean handleFault(SOAPMessageContext arg0) {
        // Do nothing
        return true;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (!outboundProperty.booleanValue()) {
            try {
                SOAPBody soapBody = smc.getMessage().getSOAPBody();
                soapBody.removeNamespaceDeclaration("ns0");
                soapBody.addNamespaceDeclaration("s0", "urn:HPD_IncidentInterface_WS");
                SOAPElement oldElement = (SOAPElement) soapBody.getFirstChild();
                cloneToNewNamespace(oldElement, soapBody, "s0");
                soapBody.removeChild(oldElement);
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private void cloneToNewNamespace(Node nodeToRename, SOAPElement parentElement, String prefix) throws SOAPException {
        if (nodeToRename instanceof SOAPElement) {
            SOAPElement elementToRename = (SOAPElement) nodeToRename;
            SOAPElement newElement = parentElement.addChildElement(elementToRename.getElementName().getLocalName(), prefix);
            for (int index = 0; index < elementToRename.getChildNodes().getLength(); index++) {
                Node childNode = elementToRename.getChildNodes().item(index);
                cloneToNewNamespace(childNode, newElement, prefix);
            }
        } else {
            parentElement.addTextNode(nodeToRename.getNodeValue());
        }
    }

    @Override
    public Set<QName> getHeaders() {
        // Do nothing
        return null;
    }
}