public static AutomatedIDResponse xmlToObject(String xmlString) throws XMLStreamException, UnsupportedEncodingException, JAXBException{
        InputStream stream = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
        JAXBContext jaxbContext2 = JAXBContext.newInstance(AutomatedIDResponse.class);
        Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader someSource = factory.createXMLEventReader(stream);
        JAXBElement<AutomatedIDResponse> userElement = jaxbUnmarshaller2.unmarshal(someSource, AutomatedIDResponse.class);
        AutomatedIDResponse responseObject = userElement.getValue();
        return responseObject;
    }