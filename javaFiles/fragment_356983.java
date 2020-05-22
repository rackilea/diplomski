DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document docum = dBuilder.parse(inputFile);

XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
String codeToFind = "AA02";
XPathExpression expr = xpath.compile(
    String.format("/mapping-table/row[col='%s']/col[1]", codeToFind)
);
Node node = (Node) expr.evaluate(docum, XPathConstants.NODE);
System.out.println(node.getTextContent());