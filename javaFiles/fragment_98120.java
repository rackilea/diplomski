public <T> T testXmlToObject(InputStream line, Class<T> classe)  {
    try {
        JAXBContext jaxbContext = JAXBContext.newInstance(classe);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        T object = (T) jaxbUnmarshaller.unmarshal(line);
        return object;
    } catch (JAXBException e) {
        e.printStackTrace();
    }
    return null;
}