try {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document dom = db.parse(new File("Test.xml"));
    XPath xpath = XPathFactory.newInstance().newXPath();

    // Find the "thing" node...
    XPathExpression thingExpr = xpath.compile("/branches/branch-area/branch/tab");
    Node things = (Node) thingExpr.evaluate(dom, XPathConstants.NODE);
    String table = things.getTextContent();

    ByteArrayInputStream bais = new ByteArrayInputStream(table.getBytes());
    Document tblDom = db.parse(bais);
    XPathExpression tableExp = xpath.compile("/table/tr[td[text()='Sort Code']]/td[not(@*)]");
    NodeList nodes = (NodeList) tableExp.evaluate(tblDom, XPathConstants.NODESET);
    System.out.println(nodes.getLength());
    for (int index = 0; index < nodes.getLength(); index++) {
        Node node = nodes.item(index);
        System.out.println(node.getTextContent());
    }
} catch (Exception exp) {
    exp.printStackTrace();
}