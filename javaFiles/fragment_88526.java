public static void traverse(Node node) {
    NodeList nodeList = node.getChildNodes();
    for (int i = 0; i < nodeList.getLength(); i++) {
        // gets the current node
        Node currentNode = nodeList.item(i);

        // Do stuff with current node first
        if (currentNode.getNodeName().equals("container")) {
            for (int j = 0; j < currentNode.getChildNodes().getLength(); j++) {
                if (currentNode.getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) currentNode.getChildNodes().item(j);
                    System.out.println(e.getAttribute("name") + " "
                            + currentNode.getChildNodes().item(j).getNodeName());
                }
            }
        }

        // traverse deeper after having done stuff with current node (above)
        if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
            traverse(currentNode);
        }
    }
}