public <T> void setOthersInXML(T data) throws JAXBException, ParserConfigurationException{
        JAXBContext context = JAXBContext.newInstance(data.getClass());
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db= dbf.newDocumentBuilder();
        Document document = db.newDocument();
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(data, document);
        others = new Object[]{document.getDocumentElement()};
    }