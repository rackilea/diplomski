public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException, XPathExpressionException {
    final String pXML = "<root><x>1</x><x>2</x><x>3</x><x>4</x></root>";
    final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(pXML.getBytes()));
    final XPathExpression xPathExpression = XPathFactory.newInstance().newXPath().compile("//x/text()");
    final NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
    final List<String> values = new LinkedList<>();
    for (int i = 0; i < nodeList.getLength(); ++i) {
        values.add(nodeList.item(i).getNodeValue());
    }
    System.out.println(values);
}