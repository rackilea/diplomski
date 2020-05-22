XPath xp = XPathFactory.newInstance().newXPath();
    NodeList list = (NodeList) xp.evaluate("//node[*[@* = 'down']]", doc, XPathConstants.NODESET);
    for(int i=0; i < list.getLength(); ++i) {
        Node node = list.item(i);
        node.getParentNode().removeChild(node);
    }