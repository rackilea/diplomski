public String getWSAAddress(W3CEndpointReference ref) {
    Element element = DOMUtils.createDocument().createElement("elem");
    ref.writeTo(new DOMResult(element));
    NodeList nl = element.getElementsByTagNameNS("http://www.w3.org/2005/08/addressing", "Address");
    if (nl != null && nl.getLength() > 0) {
        Element e = (Element) nl.item(0);
        return DOMUtils.getContent(e).trim();
    }
    return null;
}