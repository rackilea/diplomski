@Test
public void yourTest() throws ParserConfigurationException, SAXException,
        IOException {
    // File fXmlFile = new File("http://vimeo.com/api/v2/video/" + 21331554
    // + ".xml");

    InputStream is = new ClassPathResource("vimeo.xml").getInputStream();

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(is);
    doc.getDocumentElement().normalize();
    String val = doc.getElementsByTagName("thumbnail_medium").item(0)
            .getTextContent();

    System.out.println(val);

}