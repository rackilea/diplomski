final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setValidating(true);
factory.setIgnoringElementContentWhitespace(true);
final DocumentBuilder builder = factory.newDocumentBuilder();
final Document doc = builder.parse("input.xml");

final Node rootNode = doc.getDocumentElement();
final Element childElement = (Element) rootNode.getFirstChild();

System.out.println(childElement.getNodeName());