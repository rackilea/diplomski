package org.example.sampleservice;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.MessageContext.Scope;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class UsernameTokenHandler implements SOAPHandler<SOAPMessageContext> {

    private static final String WSSE_NS_URI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    private static final QName QNAME_WSSE_USERNAMETOKEN = new QName(WSSE_NS_URI, "UsernameToken");
    private static final QName QNAME_WSSE_USERNAME = new QName(WSSE_NS_URI, "Username");
    private static final QName QNAME_WSSE_PASSWORD = new QName(WSSE_NS_URI, "Password");

    @Override
    public boolean handleMessage(SOAPMessageContext context) {

        Boolean outbound = (Boolean) context
                .get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if ((outbound != null) && (!outbound.booleanValue())) {
            handleInboundMessage(context);
        }
        return true;
    }

    private void handleInboundMessage(SOAPMessageContext context) {
        String wsseUsername = null;
        String wssePassword = null;
        try {
            SOAPHeader header = context.getMessage().getSOAPHeader();
            Iterator<?> headerElements = header.examineAllHeaderElements();
            while (headerElements.hasNext()) {
                SOAPHeaderElement headerElement = (SOAPHeaderElement) headerElements
                        .next();
                if (headerElement.getElementName().getLocalName()
                        .equals("Security")) {
                    SOAPHeaderElement securityElement = headerElement;
                    Iterator<?> it2 = securityElement.getChildElements();
                    while (it2.hasNext()) {
                        Node soapNode = (Node) it2.next();
                        if (soapNode instanceof SOAPElement) {
                            SOAPElement element = (SOAPElement) soapNode;
                            QName elementQname = element.getElementQName();
                            if (QNAME_WSSE_USERNAMETOKEN.equals(elementQname)) {
                                SOAPElement usernameTokenElement = element;
                                wsseUsername = getFirstChildElementValue(usernameTokenElement, QNAME_WSSE_USERNAME);
                                wssePassword = getFirstChildElementValue(usernameTokenElement, QNAME_WSSE_PASSWORD);
                                break;
                            }
                        }

                        if (wsseUsername != null) {
                            break;
                        }
                    }
                }
                context.put("USERNAME", wsseUsername);
                context.setScope("USERNAME", Scope.APPLICATION);

                context.put("PASSWORD", wssePassword);
                context.setScope("PASSWORD", Scope.APPLICATION);
            }
        } catch (Exception e) {
            System.out.println("Error reading SOAP message context: " + e);
            e.printStackTrace();
        }

    }

    private String getFirstChildElementValue(SOAPElement soapElement, QName qNameToFind) {
        String value = null;
        Iterator<?> it = soapElement.getChildElements(qNameToFind);
        while (it.hasNext()) {
            SOAPElement element = (SOAPElement) it.next(); //use first
            value = element.getValue();
        }
        return value;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {
    }


    @Override
    public Set<QName> getHeaders() {
        return null;
    }

}