for (int i=0; i<list.getLength(); i++) {
        org.w3c.dom.Node elem = list.item(i);
        if (elem.getNodeType() == org.w3c.dom.Node.TEXT_NODE && 
                elem.getNodeValue().trim().isEmpty()) {
            continue;
        }
        taglist.add(elem.getNodeName());
    }