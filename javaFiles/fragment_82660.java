XPath xp = XPathFactory.newInstance();
NodeList elements = (NodeList) xp.evaluate(doc, "//ROW/*", XPathConstants.NODESET); 
for(int i=0; i < elements.getLength(); ++i) {
    String name = elements.itemt(i).getNodeName();
    String value = elements.itemt(i).getTextContent();
}