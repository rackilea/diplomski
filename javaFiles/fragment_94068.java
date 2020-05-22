NodeList frames;
try {
    XPath xpath = XPathFactory.newInstance().newXPath();
    frames = (NodeList) xpath.evaluate("//*" +
        "[local-name() = 'frame'" +
        " or local-name() = 'FRAME'" + 
        " or local-name() = 'iframe'" + 
        " or local-name() = 'IFRAME']" + 
        "[@src]", doc, XPathConstants.NODESET);
} catch (XPathException e) {
    throw new RuntimeException(e);
}