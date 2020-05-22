public static Iterator<String> getAttributes(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
    ArrayList<String> attributes = new ArrayList<String>();
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(xmlFile);
    /*
     * optional, but recommended read this -
     * http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with
     * -java-how-does-it-work
     */
    doc.getDocumentElement().normalize();

    NodeList nList = doc.getElementsByTagName("setting");

    for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;

            String group = eElement.getElementsByTagName("group").item(0).getTextContent();
            String name = eElement.getElementsByTagName("name").item(0).getTextContent();
            String job = eElement.getElementsByTagName("job").item(0).getTextContent();

            attributes.add(group);
            attributes.add(name);
            attributes.add(job);
        }
    }
    return attributes.iterator();
}