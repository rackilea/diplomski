DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder =  factory.newDocumentBuilder();
    Document doc = builder.parse("test.xml");

    XPathFactory xFactory = XPathFactory.newInstance();
    XPath xpath = xFactory.newXPath();
    XPathExpression  expr = xpath.compile("//command/text()");
    Object result = expr.evaluate(doc, XPathConstants.NODESET);

    NodeList nodes = (NodeList) result;
    for (int i=0; i<nodes.getLength();i++){
      System.out.println(nodes.item(i).getNodeValue());
    }