@Test
public void dom4j() throws DocumentException, IOException {
  String absolutePath = Paths.get(PATH_TO_XML).toAbsolutePath().toString();

  SAXReader reader = new SAXReader();
  Document document = reader.read(absolutePath);
  Node node = document.selectSingleNode(XPATH_TO_NODE);

  node.detach();

  XMLWriter writer = new XMLWriter(new FileWriter(absolutePath), OutputFormat.createPrettyPrint());
  writer.write(document);
  writer.close();
}