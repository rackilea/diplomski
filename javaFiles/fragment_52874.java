Map<String, String> uris = new HashMap<String, String>();
uris.put("wms", "http://www.opengis.net/wms");
XPath xpath1 = doc.createXPath("//wms:Layer");
xpath1.setNamespaceURIs(uris);
List nodes1 = xpath1.selectNodes(doc);

for (Iterator<?> layerIt = nodes1.iterator(); layerIt.hasNext();) {
    Node node = (Node) layerIt.next();
    XPath nameXpath = node.createXPath("./wms:Name");
    nameXpath.setNamespaceURIs(uris);
    XPath titleXpath = node.createXPath("./wms:Title");
    titleXpath.setNamespaceURIs(uris);
    Node name = nameXpath.selectSingleNode(node);
    Node title = titleXpath.selectSingleNode(node);
}