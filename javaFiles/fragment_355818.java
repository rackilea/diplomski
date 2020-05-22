public <T> T  toPOJO(String xml, Class<T> type) throws Exception {
        InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader someSource = factory.createXMLEventReader(stream);
        JAXBElement<T> userElement = jaxbUnmarshaller.unmarshal(someSource, type);
        return userElement.getValue();
}