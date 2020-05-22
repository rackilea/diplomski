public static void main(String[] args) throws Exception {
    DocumentBuilder domBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = domBuilder.newDocument();
    Element root = doc.createElement("Root");
    doc.appendChild(root);
    root.appendChild(doc.createTextNode("Hello"));
    root.appendChild(doc.createTextNode(" "));
    root.appendChild(doc.createTextNode("World"));
    printDom("", doc);
    doc.normalizeDocument();
    printDom("", doc);
}