XPath xpath = XPathFactory.newInstance().newXPath();
XPathExpression branchExp = xpath.compile("/branches/branch-area[@name='abc']/branch/*");
NodeList branchNodes = (NodeList) branchExp.evaluate(dom, XPathConstants.NODESET);
System.out.println(branchNodes.getLength());
for (int index = 0; index < branchNodes.getLength(); index++) {
    Node node = branchNodes.item(index);
    System.out.println(node.getTextContent());
}