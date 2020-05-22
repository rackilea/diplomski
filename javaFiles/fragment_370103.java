File file = new File("xmlfile.xml");
    DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document xml = dBuilder.parse(file);
    XPath xpath = XPathFactory.newInstance().newXPath();
    Node portNode = (Node) xpath.compile("/ServerSettings/property[@name='ServerPort']").evaluate(xml, XPathConstants.NODE);
    portNode.getAttributes().getNamedItem("value").setNodeValue("8080");

    // Saving changed XML back
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    Result output = new StreamResult(new File("xmlfile.xml"));
    Source input = new DOMSource(xml);
    transformer.transform(input, output);