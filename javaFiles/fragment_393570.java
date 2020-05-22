Element el = (Element)(doc.getElementsByTagName("node").item(0));
NodeList children = el.getChildNodes();

for (int i=0; i<children.getLength(); i++) {
  System.out.println(children.item(0).getNodeValue());
}