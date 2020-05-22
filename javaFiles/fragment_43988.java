private static void changeValue(Node someNode, Document doc, String searchString) throws Exception {
    XPath xPath = XPathFactory.newInstance().newXPath();
    NodeList nodes = (NodeList) xPath.evaluate("//*[@*=\"" + searchString + "\"]", 
                                                doc.getDocumentElement(),
                                                XPathConstants.NODESET);

    for (int i = 0; i < nodes.getLength(); i++) {
        System.out.println("Tagname: " + nodes.item(i).getNodeName());
    }
}