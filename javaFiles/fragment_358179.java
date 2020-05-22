catch (com.sun.xml.ws.fault.ServerSOAPFaultException soapFaultException) {

    javax.xml.soap.SOAPFault fault = soapFaultException.getFault(); // <Fault> node
    javax.xml.soap.Detail detail = fault.getDetail(); // <detail> node
    java.util.Iterator detailEntries = detail.getDetailEntries(); // nodes under <detail>'
    while(detailEntries.hasNext()) {
        javax.xml.soap.DetailEntry detailEntry = (DetailEntry) detailEntries.next();
        System.out.println(detailEntry.getFirstChild().getTextContent());
        System.out.println(detailEntry.getLastChild().getTextContent());
    }   
}