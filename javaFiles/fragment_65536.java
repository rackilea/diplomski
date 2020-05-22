File myXml = new File("SQL.xml");

DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(myXml);
doc.getDocumentElement().normalize();

NodeList nList = doc.getElementsByTagName("QUERY");

for (int i = 0; i < nList.getLength(); i++)
{
    Node nNode = nList.item(i);

    Element eElement = (Element) nNode;
    System.out.println("SELECT " + eElement.getElementsByTagName("SELECT").item(0).getTextContent());
    System.out.println("FROM " + eElement.getElementsByTagName("TABLE").item(0).getTextContent());
    System.out.println("JOIN " + eElement.getElementsByTagName("JOIN").item(0).getTextContent());
    System.out.println("WHERE " + eElement.getElementsByTagName("WHERE").item(0).getTextContent());
    System.out.println("GROUP " + eElement.getElementsByTagName("GROUP").item(0).getTextContent());
    System.out.println("ORDER " + eElement.getElementsByTagName("ORDER").item(0).getTextContent());
}