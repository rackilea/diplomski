DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
domFactory.setNamespaceAware(true); // never forget this!
DocumentBuilder builder = domFactory.newDocumentBuilder();
Document doc = builder.parse("myInput.xml");

XPathFactory factory = XPathFactory.newInstance();
XPath xpath = factory.newXPath();
XPathExpression expr = xpath.compile("//type[type_def_id = '9']");

Object result = expr.evaluate(doc, XPathConstants.NODESET);
NodeList nodes = (NodeList) result;
for (int i = 0; i < nodes.getLength(); i++) {
    // do what you need to do...
}