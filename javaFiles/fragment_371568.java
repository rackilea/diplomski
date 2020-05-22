XPathFactory xPathFactory = XPathFactory.newInstance();
XPath xPath = xPathFactory.newXPath();
xPath.setNamespaceContext(new NamespaceContext() {
    @Override
    public String getNamespaceURI(String prefix) {
        if ("main".equals(prefix)) {
            return "http://a-random-URL";
        }
        if ("secondary".equals(prefix)) {
            return "http://another-random-URL";
        }
        return null;
    }
    @Override
    public String getPrefix(String namespaceURI) {
        // This should be implemented but I'm lazy and this sample works without it
        return null;
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
        // This should be implemented but I'm lazy and this sample works without it
        return null;
    }
});
XPathExpression xpr = xPath.compile("/main:Envelope/secondary:Triangle");
NodeList nodes = (NodeList)xpr.evaluate(doc, XPathConstants.NODESET);
System.out.println(nodes.getLength());