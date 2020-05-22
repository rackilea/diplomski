SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
URL schemaURL = // The URL to your XML Schema; 
Schema schema = sf.newSchema(schemaURL); 
Validator validator = schema.newValidator();
DOMSource source = new DOMSource(xmlDOM);
validator.validate(source);