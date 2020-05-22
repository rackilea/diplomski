SchemaFactory schemaFactory = SchemaFactory
    .newInstance(XMLConstants.XML_DTD_NS_URI);
Schema schema = schemaFactory.newSchema(new File(
    "xmlValidate.dtd"));
Validator validator = schema.newValidator();
validator.validate(new StreamSource("xmlValidate.xml"));