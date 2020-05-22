public NodeList query() throws ParserConfigurationException, 
                        SAXException,IOException,XPathExpressionException {

        ...

        // Cast the result to a DOM NodeList
        NodeList nodes = (NodeList) result;

        return nodes;
}