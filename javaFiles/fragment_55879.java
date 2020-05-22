XPathFactory xpathFactory = XPathFactory.newInstance();
XPath xpath = xpathFactory.newXPath();

tagA = xpath.evaluate("a", fileNode);
tagB = xpath.evaluate("b", fileNode);
tagC = xpath.evaluate("c", fileNode);