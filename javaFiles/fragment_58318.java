Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
doc.appendChild(doc.createElement("root"));
for (int i = 0; i < nodeList.getLength(); i++) {
    Node node = nodeList.item(i);
    doc.getDocumentElement().appendChild(doc.importNode(node, true));
}