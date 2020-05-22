static String inputFile = "./beans.xml";
static String outputFile = "./beans_new.xml";

// 1- Build the doc from the XML file
Document doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder().parse(new InputSource(inputFile));

// 2- Locate the node(s) with xpath
XPath xpath = XPathFactory.newInstance().newXPath();
NodeList nodes = (NodeList)xpath.evaluate("//*[contains(@value, '!Here')]",
                                          doc, XPathConstants.NODESET);

// 3- Make the change on the selected nodes
for (int idx = 0; idx < nodes.getLength(); idx++) {
    Node value = nodes.item(idx).getAttributes().getNamedItem("value");
    String val = value.getNodeValue();
    value.setNodeValue(val.replaceAll("!Here", "What?"));
}

// 4- Save the result to a new XML doc
Transformer xformer = TransformerFactory.newInstance().newTransformer();
xformer.transform(new DOMSource(doc), new StreamResult(new File(outputFile)));