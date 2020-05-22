XMLParser parser = new XMLParser();
        Document doc = parser.getDomElement(xml); // getting DOM element
        NodeList n1 = doc.getElementsByTagName("company");

        // looping through all item nodes <item>
        for (int i = 0; i < n1.getLength(); i++) {
            Element e = (Element) n1.item(i);
            System.out.println("name node "  +parser.getValue(e, "name"));
            NodeList children = e.getChildNodes();
            for (int j = 0; j < children.getLength(); j++) {
                 Node child = children.item(j);
                 if (child.getNodeName().equalsIgnoreCase("province")) {
                      System.out.println("name node " + parser.getValue((Element)child, "name"));
                 }
            }
        }