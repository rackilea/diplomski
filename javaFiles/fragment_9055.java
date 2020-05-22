private double extractVersion(Document doc){

String result = "";

NodeList nodeList = doc.getElementsByTagName("latest");
for (int i = 0; i < nodeList.getLength(); i++) {
    Node node = nodeList.item(i);
    if (node.getNodeName().equals("latest")) {
        result = node.getTextContent();
    }
}

return Double.parseDouble(result);
}