NodeList nodes = doc.getDocumentElement().getChildNodes();
for (int i = 0; i < nodes.getLength(); i++) {
  Node node = nodes.get(i);
  if (node instanceof Element) {
    Element childElement = (Element) node;
    System.out.println("tag name: " + childElement.getTagName());
  }
}