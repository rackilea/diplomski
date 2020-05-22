NodeList nodeList = doc.getElementsByTagName("headnode");
for (int i = 0; i < nodeList.getLength(); i++) {
    Node node = nodeList.item(i);
    NodeList childList = node.getChildNodes();
    for (int j = 0; j < childList.getLength(); j++) {
        Node childNode = childList.item(j);
        if (childNode.getNodeName().equals("info")) {
            String info = childNode.getTextContent();
            System.out.println(info);
        }
    }
}