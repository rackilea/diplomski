@Test
public void printXml() {
    String yourSampleFile = "52720162.xml";
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(yourSampleFile)) {
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(in);
        NodeList list = filterNodesByXPath(doc, "//root/Entity");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            printNode(node);
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

private NodeList filterNodesByXPath(Document doc, String xpathExpr) {
    try {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        XPathExpression expr = xpath.compile(xpathExpr);
        Object eval = expr.evaluate(doc, XPathConstants.NODESET);
        return (NodeList) eval;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

private void printNode(Node node) throws TransformerFactoryConfigurationError, TransformerException {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
    StreamResult result = new StreamResult(new StringWriter());
    DOMSource source = new DOMSource(node);
    transformer.transform(source, result);
    String xmlString = result.getWriter().toString();
    System.out.println(xmlString);
}