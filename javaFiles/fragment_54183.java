ClassPathResource classPathResource = new ClassPathResource("samples/form2/data/test.xml");
    XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
    xmlInputFactory.setProperty(XMLInputFactory.IS_COALESCING, true);
    XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(classPathResource.getInputStream());

    JAXBContext jaxbContext = JAXBContext.newInstance(EntityRecordData.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    int eventType = xmlStreamReader.next();
    while(true){
        switch (eventType) {
        case XMLEvent.START_ELEMENT:
            System.out.println("Element: "+xmlStreamReader.getLocalName());
            if("record".equals(xmlStreamReader.getLocalName())){
                JAXBElement<EntityRecordData> unmarshal = unmarshaller.unmarshal(xmlStreamReader, EntityRecordData.class);
                final List<IFieldData> fields = unmarshal.getValue().getFields();
                System.out.println("**"+fields.get(0).getId());
            } else {
                eventType = xmlStreamReader.next();
            }
            break;
        case XMLEvent.CHARACTERS: 
            String text = xmlStreamReader.getText();
            System.out.println("Text: "+text);
            eventType = xmlStreamReader.next();
            break;
        case XMLEvent.END_ELEMENT: 
            //System.out.println("End: "+xmlStreamReader.getLocalName());
            eventType = xmlStreamReader.next();
            break;
        default : 
            break;
        }

        if(!xmlStreamReader.hasNext()){
            break;
        }
    }
    xmlStreamReader.close();