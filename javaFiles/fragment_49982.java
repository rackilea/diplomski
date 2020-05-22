public static void main(String argv[]) {

    Map<String, String> map = new LinkedHashMap<>();

    try {
        File fXmlFile = new File("staff.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        NodeList collectionNodeList = doc.getElementsByTagName("collection");
        Element collectionElement = (Element) collectionNodeList.item(0);
        findElementsWithValues(map, collectionElement);

    } catch (Exception e) {
        e.printStackTrace();
    }

    System.out.println("Found values: " + map.size());
    System.out.println(map);
}

private static void findElementsWithValues(Map<String, String> map, Element rootElement) {
    NodeList childNodes = rootElement.getChildNodes();
    for (int i = 0; i < childNodes.getLength(); i++) {
        Node node = childNodes.item(i);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            String value = element.getAttribute("value");
            if (!value.isEmpty()) {
                String tagName = element.getTagName();
                map.put(tagName, value);
            }else{
                findElementsWithValues(map, element);
            }
        }
    }
}