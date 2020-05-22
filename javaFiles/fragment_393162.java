@Test
public void domTestVimeo() throws ParserConfigurationException,
        SAXException, IOException {

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new ClassPathResource("vimeo.xml")
            .getInputStream());
    doc.getDocumentElement().normalize();

    String val = ((Node) doc.getElementsByTagName("thumbnail_medium"))
            .getNodeValue();

    System.out.println(val);

}