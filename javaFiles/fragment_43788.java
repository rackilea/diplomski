JAXBContext jc = JAXBContext.newInstance(Customer.class);
Unmarshaller unmarshaller = jc.createUnmarshaller();

SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
URL schemaURL = // The URL to your XML Schema; 
Schema schema = sf.newSchema(schemaURL); 
unmarshaller.setSchema(schema);

JAXBElement<Customer> element = (JAXBElement<Customer>) unmarshaller.unmarshal(xml);
Customer customer = elemnt.getValue();