public static void main(String[] args) throws Exception {

    File xmlFile = new File("data.xml");

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    org.w3c.dom.Document document = documentBuilder.parse(xmlFile);

    NodeList list = document.getElementsByTagName("Developer");

    List<Developer> developers = new ArrayList<>();

    for (int i = 0; i < list.getLength(); i++) {

        Node node = list.item(i);

        if (node.getNodeType() == Node.ELEMENT_NODE) {

            Element element = (Element) node;

            Developer developer = new Developer(
                element.getAttribute("Id"),
                element.getElementsByTagName("Name").item(0).getTextContent(),
                element.getElementsByTagName("Surname").item(0).getTextContent(),
                Integer.parseInt(element.getElementsByTagName("Age").item(0).getTextContent())
            );
            developers.add(developer);
        }
    }

    // at this point we have a list of developers

    // print out all the developers
    for (Developer developer : developers) {
        System.out.println("ID: " + developer.getId());
        System.out.println("Name: " + developer.getName());
        System.out.println("Surname: " + developer.getSurname());
        System.out.println("Age: " + developer.getAge());
    }
}