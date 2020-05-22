File xmlFile = new File("src/main/resources/example.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document element = dBuilder.parse(xmlFile);

NodeList list = element.getElementsByTagName("ID");
for (int i = 0; i < list.getLength(); i++){
    Node specificIDNode = list.item(i);
    System.out.println(specificIDNode.getTextContent());
}