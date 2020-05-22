public static void main(String[] args) 
   throws ParserConfigurationException, SAXException, 
          IOException, XPathExpressionException {

    DocumentBuilderFactory domFactory = 
    DocumentBuilderFactory.newInstance();
          domFactory.setNamespaceAware(true); 
    DocumentBuilder builder = domFactory.newDocumentBuilder();
    Document doc = builder.parse("persons.xml");
    XPath xpath = XPathFactory.newInstance().newXPath();
       // XPath Query for showing all nodes value
    XPathExpression expr = xpath.compile("//person/*/text()");

    Object result = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList nodes = (NodeList) result;
    for (int i = 0; i < nodes.getLength(); i++) {
     System.out.println(nodes.item(i).getNodeValue()); 
    }
  }