String xml = "your XML";

// load the XML as String into a DOM Document object
DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
ByteArrayInputStream bis = new ByteArrayInputStream(xml.getBytes());
Document doc = docBuilder.parse(bis);

// XPath to retrieve the content of the <version>/<description> tag
XPath xpath = XPathFactory.newInstance().newXPath();
XPathExpression expr = xpath.compile("/version/description");
Node description = (Node)expr.evaluate(doc, XPathConstants.NODE);
System.out.println("description: " + description.getTextContent());