XPath xpath = XPathFactory.newInstance().newXPath();
XPathExpression branchExp = xpath.compile("/branches/branch-area[@name='abc']/branch");
Node branchNode = (Node) branchExp.evaluate(dom, XPathConstants.NODE);

XPathExpression nameExp = xpath.compile("branch-name/text()");
String name = (String) nameExp.evaluate(branchNode, XPathConstants.STRING);
System.out.println("Name = " + name);