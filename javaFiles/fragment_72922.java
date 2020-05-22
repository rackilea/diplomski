public T extractData(Source source) throws IOException {
    Node rootNode = ((DOMSource)source)
    NodeList nodes = rootNode.getChildElements();
    for (int i = 0; i < nodes.getLength(); i++) {
        String nodeText = nodes.item(i).getTextContent();
        /* Remainder of loop and method elided */
    }
}