try
{
  DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
  DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
  Document doc = docBuilder.parse(filePath);
  Node rootNode = doc.getFirstChild();//for getting the root node

  String expersion="books/author";//x-path experssion

  XPathFactory factory = XPathFactory.newInstance();
  XPath xpath = factory.newXPath();
  XPathExpression expr = xpath.compile(expersion);
  Node updateNode=null;
  Object result = expr.evaluate(doc, XPathConstants.NODESET);
  NodeList nodes = (NodeList) result;
  updateNode=nodes.item(0);
  updateNode.appendChild(doc.createCDATASection("new value"));
  TransformerFactory transformerFactory = TransformerFactory.newInstance();
  Transformer transformer = transformerFactory.newTransformer();
  DOMSource source = new DOMSource(doc);
  StreamResult streamResult =  new StreamResult(new File(filePath));
  transformer.transform(source, streamResult);
}
catch (Exception e) {
  e.printStackTrace();
}