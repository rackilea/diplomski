public static IBUSStatusType getIBUSStatusType(String xml)
      throws JAXBException, SAXException, IOException, ParserConfigurationException
  {
    JAXBContext jaxbContext = JAXBContext
        .newInstance(IBUSStatusType.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();    
    
    Element node =  DocumentBuilderFactory
        .newInstance()
        .newDocumentBuilder()
        .parse(new ByteArrayInputStream(xml.getBytes()))
        .getDocumentElement();
    
    return ((JAXBElement<IBUSStatusType>) jaxbUnmarshaller.unmarshal(node, IBUSStatusType.class)).getValue();
  }