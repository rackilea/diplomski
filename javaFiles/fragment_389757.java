Object set = xpath.evaluate("*/*/foo", doc, XPathConstants.NODESET);

NodeList list = (NodeList) set;
int count = list.getLength();
for (int i = 0; i < count; i++) {
    Node node = list.item(i);
    // Handle the node
}