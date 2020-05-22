@Override
public void handleMessage(SoapMessage message) throws Fault{
    SOAPMessage saaj = message.getContent(SOAPMessage.class);
    Document doc = saaj.getSOAPPart(); // This actually returns a SOAPPart instance but it does implement the w3c Document interface

    //play around with the document, doc is a reference so any changes made to that instance
    //will be forwarded to the rest of the chain
}