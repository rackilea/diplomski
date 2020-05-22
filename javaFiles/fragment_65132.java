// note that if your XML already declares the XSD to which it has to conform, then there's no need to declare the schemaName here
void validate(String xml, String schemaName) throws Exception {

    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    builderFactory.setNamespaceAware(true);

    DocumentBuilder parser = builderFactory
            .newDocumentBuilder();

    // parse the XML into a document object
    Document document = parser.parse(new StringInputStream(xml));

    SchemaFactory factory = SchemaFactory
            .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    // associate the schema factory with the resource resolver, which is responsible for resolving the imported XSD's
    factory.setResourceResolver(new ResourceResolver());

            // note that if your XML already declares the XSD to which it has to conform, then there's no need to create a validator from a Schema object
    Source schemaFile = new StreamSource(getClass().getClassLoader()
            .getResourceAsStream(schemaName));
    Schema schema = factory.newSchema(schemaFile);

    Validator validator = schema.newValidator();
    validator.validate(new DOMSource(document));
}