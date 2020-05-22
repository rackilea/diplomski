final XPath xPath = XPathFactory.newInstance().newXPath();
xPath.setNamespaceContext(new NamespaceContext() {
    @Override
    public Iterator<String> getPrefixes(final String namespaceURI) {
        return null;
    }
    @Override
    public String getPrefix(final String namespaceURI) {
        return null;
    }
    @Override
    public String getNamespaceURI(final String prefix) {
        return "http://c1.net.corbis.com/";
    }
});
final NodeList list = (NodeList) xPath.evaluate("//c:URL128/@Value", source, XPathConstants.NODESET);
for (int i = 0; i < list.getLength(); i++) {
    System.out.println(list.item(i).getTextContent());
}