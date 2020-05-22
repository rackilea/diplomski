public static void main(String[] args) throws Exception {
  File file = new File("data.xml");
  DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
 //if you are using this code for blackberry xml parsing
  builder.setCoalescing(true);
  Document doc = builder.parse(file);

  NodeList nodes = doc.getElementsByTagName("topic");
  for (int i = 0; i < nodes.getLength(); i++) {
    Element element = (Element) nodes.item(i);
    NodeList title = element.getElementsByTagName("title");
    Element line = (Element) title.item(0);
    System.out.println("Title: " + getCharacterDataFromElement(line));
  }
}
public static String getCharacterDataFromElement(Element e) {
  Node child = e.getFirstChild();
  if (child instanceof CharacterData) {
    CharacterData cd = (CharacterData) child;
    return cd.getData();
  }
  return "";
}