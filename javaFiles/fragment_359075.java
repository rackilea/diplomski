<T> T unmarshal(String filename, Class<T> clazz) throws Exception {
    XMLInputFactory xif = XMLInputFactory.newFactory();
    XMLStreamReader xsr = xif.createXMLStreamReader(getClass().getResourceAsStream(filename));
    xsr.nextTag();
    while (!xsr.getLocalName().equals("Body")) {
        xsr.nextTag();
    }
    xsr.nextTag();
    Unmarshaller unmarshaller = JAXBContext.newInstance(clazz).createUnmarshaller();
    return unmarshaller.unmarshal(xsr, clazz).getValue();
}