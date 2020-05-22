Node alertNode = doc.getElementsByTagName("ALERTS").item(0);
    NodeList nodeList = alertNode.getChildNodes();
    for (int i = 0; i < nodeList.getLength(); i++) {

        Node node = nodeList.item(i);
        System.out.println("NodeName:" + node.getNodeName() + ":TextContent:" + node.getTextContent());
        if ("RESPONSEID".equalsIgnoreCase(node.getNodeName())) {
            node.setTextContent("RESPONSEID-1");
        }
    }