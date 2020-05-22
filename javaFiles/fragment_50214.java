XPath xpath = XPathFactory.newInstance().newXPath();
XPathExpression xPathExpression1 = xpath.compile("//bins/*");
Object result1 = xPathExpression1.evaluate(document, XPathConstants.NODESET);

NodeList nodeList1 = (NodeList) result1;
for (int i = 0; i < nodeList1.getLength(); i++) {
    XPathExpression xPathExpression2 = xpath.compile("*/text()");
    Object result2 = xPathExpression2.evaluate(nodeList1.item(j), XPathConstants.NODESET);
    NodeList nodeList2 = (NodeList) result2;
    List<String> binList = new ArrayList<>();
    for (int j = 0; j < nodeList2.getLength(); j++) {
        binList.add(nodeList2.item(j).getNodeValue());
    }
    binDataList.add(binList);
}