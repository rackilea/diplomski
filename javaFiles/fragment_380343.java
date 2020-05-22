public static String getTrimmedXML(String rawXMLFilename, String tagName) throws Exception {
    // Create xml document object
    BufferedReader in = new BufferedReader(new FileReader(rawXMLFilename));
    InputSource source = new InputSource(in);
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document document = db.parse(source);
    XPathFactory xpathFactory = XPathFactory.newInstance();
    XPath xpath = xpathFactory.newXPath();

    // Path to the node that you want to trim
    NodeList nodeList = (NodeList) xpath.compile("//*[name()='" + tagName + "']").evaluate(document, XPathConstants.NODESET);
    for (int index = 0; index < nodeList.getLength(); index++) { // Loop through all nodes that match the xpath
        Node node = nodeList.item(index);
        String newTextContent = node.getTextContent().trim(); // Actual trim process
        node.setTextContent(newTextContent);
    }

    // Transform back the document to string format.
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    StringWriter writer = new StringWriter();
    transformer.transform(new DOMSource(document), new StreamResult(writer));
    String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
    return output;
}