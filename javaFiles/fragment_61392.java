File file = new File("path to file");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(file);
    XPath xPath = XPathFactory.newInstance().newXPath();

    String expression = "//document-instance/@link";
    Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
    String url= node.getTextContent();