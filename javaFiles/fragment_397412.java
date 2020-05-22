String getAllTextContent(Node node) {
  List<Node> nodes = node.selectNodes("descendant-or-self::text()");
  StringBuilder buf = new StringBuilder();
  for ( Node n : nodes ) {
    buf.append(n.getText());
  }
  return buf.toString();
}
// usage
System.out.println(getAllTextContent(doc.selectSingleNode("//sentence")));