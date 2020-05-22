XPathFactory xPathFactory = XPathFactory.newInstance();
XPath xPath = xPathFactory.newXPath();
XPathExpression xPathExpression = xPath.compile("//object/id");

// this should return one "id" node
NodeList idNodelist = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
Node idNode = idNodelist.item(0);
System.out.println(idNode.getTextContent());