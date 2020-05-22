public T extractData(Source source) throws IOException {
    Node rootNode = ((DOMSource)source)
    NodeList nodes = rootNode.getChildElements();
    for (int i = 0; i < nodes.getLength(); i++) {
        TextImpl nodeTextImpl = (TextImpl) nodes.item(i).getFirstChild();
        String nodeText = nodeTextImpl.getData();
        /* Remainder of loop and method elided */
    }
}