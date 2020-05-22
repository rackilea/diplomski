DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
Document doc = dbf.newDocumentBuilder().parse(JavaApplication908.class.getResourceAsStream("/Hello.xml"));

XPathFactory xf = XPathFactory.newInstance();
XPath xPath = xf.newXPath();

XPathExpression expr1 = xPath.compile("//hello/entry[css/metrics/score or not(css/metrics/score)]");
XPathExpression expr2 = xPath.compile("css/metrics/score");

List<String> values = new ArrayList<>(25);

NodeList nodeList1 = (NodeList) expr1.evaluate(doc, XPathConstants.NODESET);
for (int index = 0; index < nodeList1.getLength(); index++) {
    Node node = nodeList1.item(index);
    System.out.println(node.getAttributes().getNamedItem("id"));

    Node css = (Node) expr2.evaluate(node, XPathConstants.NODE);
    if (css != null) {
        values.add(css.getTextContent());
    } else {
        values.add(null);
    }

}

for (String value : values) {
    System.out.println(value);
}