public class XmlSplit {

    public static void main(String [] args) throws Exception {
        File input = new File("input.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = dbf.newDocumentBuilder().parse(input);
        XPath xpath = XPathFactory.newInstance().newXPath();

        NodeList nodes = (NodeList) xpath.evaluate("//T0020/IRP_ACCOUNT", doc, XPathConstants.NODESET);

        int itemsPerFile = 5;
        int fileNumber = 0;
        Document currentDoc = dbf.newDocumentBuilder().newDocument();
        Node rootNode = currentDoc.createElement("T0020");
        File currentFile = new File(fileNumber+".xml");
        for (int i=1; i <= nodes.getLength(); i++) {
            Node imported = currentDoc.importNode(nodes.item(i-1), true);
            rootNode.appendChild(imported);

            if (i % itemsPerFile == 0) {
                writeToFile(rootNode, currentFile);

                rootNode = currentDoc.createElement("T0020");
                currentFile = new File((++fileNumber)+".xml");
            }
        }

        writeToFile(rootNode, currentFile);
    }

    private static void writeToFile(Node node, File file) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(node), new StreamResult(new FileWriter(file)));
    }
}