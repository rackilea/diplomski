private boolean isCompositeExists(Node fieldNode) {
  NodeList childNodes = fieldNode.getChildNodes();
  for (int i = 0; i < childNodes.getLength(); i++) {
     Node child = childNodes.item(i);
     if (child.getNodeName().equals("table") || isCompositeExists(child)) {
        return true;
     }
  }
   return false;
}