@Test   
 public void mapXmlToPojo() throws Exception {
    XMLInputFactory factory = XMLInputFactory2.newFactory();
    InputStream inputFile = MapXmlToPojo.class.getResourceAsStream("pojo.xml");
    XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(inputFile);
    XmlMapper xmlMapper = new XmlMapper();
    xmlStreamReader.next();
    xmlStreamReader.next();
    Pojo pojo = xmlMapper.readValue(xmlStreamReader, Pojo.class);
    Assert.assertEquals("test", pojo.getName());
}