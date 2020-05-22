// XPath to retrieve the content of the <version>/<description> tag
XPath xpath = XPathFactory.newInstance().newXPath();
XPathExpression expr = xpath.compile("//description");
NodeList descriptionNode = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

List<String> descriptions = new ArrayList<String>(); // hold all the descriptions as String
Transformer transformer = TransformerFactory.newInstance().newTransformer();
transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
for (int i = 0; i < descriptionNode.getLength(); ++i) {
    Node descr = descriptionNode.item(i);
    StringWriter sw = new StringWriter();
    transformer.transform(new DOMSource(descr), new StreamResult(sw));
    String description = sw.getBuffer().toString().replaceAll("</?description>", "");
    descriptions.add(description);
}
// here you can do what you want with the List of Strings `description`