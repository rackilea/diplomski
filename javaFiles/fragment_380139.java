System.out.println("Root element :"
            + doc.getDocumentElement().getNodeName());

    NodeList nList = doc.getElementsByTagName("objectgroup");

    System.out.println("----------------------------");

    for (int temp = 0; temp < nList.getLength(); temp++) {
        // for that will go for all objectGroups
        Node nNode = nList.item(temp);
        NodeList childs = nNode.getChildNodes();
        for (int i = 0; i < childs.getLength(); i++) {
            Node child = childs.item(i);
            if (child.getNodeName().equals("object")) {
                // check if we are evaluating an <object> element
                System.out.println("\nCurrent Element :"
                        + child.getNodeName());
                NamedNodeMap attrs = child.getAttributes();
                Node x = attrs.item(3), y = attrs.item(4), height = attrs
                        .item(0), width = attrs.item(2), type = attrs
                        .item(1);
                System.out.println("\n x :" + x.getNodeValue() + " | y : "
                        + y.getNodeValue() + " | height: "
                        + height.getNodeValue() + " | width: "
                        + width.getNodeValue());
            }
        }
    }