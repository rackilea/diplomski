public class DOMExampleStackOverflow3 {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {

        InputSource source = new InputSource(new StringReader("<root>\n" +
                                                            "<field name=\"firstname\">\n" +
                                                            "    <value>John</value>\n" +
                                                            "</field>\n" +
                                                            "<field name=\"lastname\">\n" +
                                                            "    <value>Citizen</value>\n" +
                                                            "</field>\n" +
                                                            "<field name=\"DoB\">\n" +
                                                            "    <value>01/01/1980</value>\n" +
                                                            "</field>\n" +
                                                            "<field name=\"Profession\">\n" +
                                                            "    <value>Manager</value>\n" +
                                                            "</field>\n" +
                                                            "</root>" ));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(source);

        NodeList allFields = (NodeList) document.getElementsByTagName("field");

        Map<String, String> data = new HashMap<>();
        for(int i = 0; i < allFields.getLength(); i++) {
            Element field = (Element)allFields.item(i);
            String nameAttribute = field.getAttribute("name");
            Element child = (Element)field.getElementsByTagName("value").item(0);
            String value = child.getTextContent();
            data.put(nameAttribute, value);
        }

        for(Map.Entry field : data.entrySet()) {
            System.out.println(field.getKey() + ": " + field.getValue());
        }
    }
}