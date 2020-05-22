Transformer transformer =
    TransformerFactory.newInstance().newTransformer();

int customerNumber = 0;
NodeList nl = doc.getDocumentElement().getChildNodes();
for (int i = 0; i < nl.getLength(); i++) {
    Node node = nl.item(i);
    if (node.getNodeType() == Node.ELEMENT_NODE) {
        customerNumber++;
        File file = new File("/tmp/customer" + customerNumber + ".xml");
        transformer.transform(
            new DOMSource(node), new StreamResult(file));
    }
}