XPathExpression expression = xpath.compile("//testcase/@name");
NodeList testcaseNames = (NodeList)expression.evaluate(document, XPathConstants.NODESET);
for (int i = 0; i < testcaseNames.getLength(); i++) {
  Node name = testcaseNames.item(i);
  name.setTextContent("browser XYZ " + name.getTextContent());
}