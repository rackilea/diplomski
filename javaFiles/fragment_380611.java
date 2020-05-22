SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
Schema schema = schemaFactory.newSchema(schemaFile); // file or URL

JAXBContext jaxbContext = JAXBContext.newInstance();
Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
unmarshaller.setSchema(schema);
unmarshaller.setEventHandler(handler); // To specify how validation errors should be handled
Object obj = unmarshaller.unmarshal(source);