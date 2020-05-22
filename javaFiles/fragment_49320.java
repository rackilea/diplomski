Map<String, String> nsMap = new HashMap<String, String>();
nsMap.put(XMLConstants.DEFAULT_NS_PREFIX, "http://www.w3.org/2005/Atom");
nsMap.put("gphoto", "http://schemas.google.com/photos/2007");

List<Node> entries = XPathAPI.selectListOfNodes(doc, "/feed/entry", nsMap);
for (Node entry : entries) {
    String id = XPathAPI.selectSingleNodeAsString(entry, "gphoto:id", nsMap);

    // or, if you prefer a Node
    // Node id = XPathAPI.selectSingleNode(entry, "gphoto:id", nsMap);
}