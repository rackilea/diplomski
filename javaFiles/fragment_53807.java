public void addNodeUsingXpath() {
    SAXReader reader = new SAXReader();
     Document document = reader.read("yourxml.xml");
        String xpathExpression = "yourxpath";
        List<Node> nodes = document.selectNodes(xpathExpression);
        // nodes will have all the child nodes under your Xpath.
        for (Node node : nodes) {
           //get the required node and add your new node to specific node.
            if(node instanceof Element) {
                 Element e = (Element) node;
                 e.addElement("newElement");
                 ....
            }
        }
}