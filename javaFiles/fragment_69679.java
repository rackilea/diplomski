DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder parser = factory.newDocumentBuilder();
Document document = parser.parse("xml/sample.xml");
NodeList personNodes = document.getElementsByTagName("person");
List<String> names = new LinkedList<String>();
for (int i = 0; i < personNodes.getLength(); i++) {
  String firstName = null;
  String lastName = null;
  Node personNode = personNodes.item(i);
  NodeList children = personNode.getChildNodes();
  for (int j = 0; j < children.getLength(); j++) {
  Node child = children.item(j);
  String nodeName = child.getNodeName();
  String nodeValue = child.getTextContent();
  if ("firstName".equals(nodeName)) {
    firstName = nodeValue;
  } else if ("lastName".equals(nodeName)) {
   lastName = nodeValue;
  } 
}
names.add(firstName + " " + lastName);
}