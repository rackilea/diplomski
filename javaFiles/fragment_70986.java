// parse the XML as a W3C Document
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document document = builder.parse(new File("/widgets.xml"));

XPath xpath = XPathFactory.newInstance().newXPath();
String expression = "/widgets/widget";
Node widgetNode = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);