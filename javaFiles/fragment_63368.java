// create a SchemaFactory capable of understanding WXS schemas
SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

// load a WXS schema, represented by a Schema instance
Source schemaFile = new StreamSource(new File("mySchema.xsd"));
Schema schema = factory.newSchema(schemaFile);

// create a Validator instance, which can be used to validate an instance document
Validator validator = schema.newValidator();

// validate the DOM tree
try {
    validator.validate(new DOMSource(document));
} catch (SAXException e) {
    // instance document is invalid!
}