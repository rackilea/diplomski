/**
 * This function validates a DomResult. T
 *
 * @param domResult
 * @param schemaFile path to the schmea file to validate against.
 * @throws org.xml.sax.SAXException
 * @throws java.io.IOException
 *
 */
protected void validateDomResult(DOMResult domResult, String schemaFile) throws SAXException, IOException, Exception {

    Schema schema = createSchema(schemaFile);
    javax.xml.validation.Validator validator = schema.newValidator();
    ErrorHandler mySchemaErrorHandler = new LoggingErrorHandler();
    validator.setErrorHandler(mySchemaErrorHandler);
    DOMSource domSource = new DOMSource(domResult.getNode());
    validator.validate(domSource);
    if (((LoggingErrorHandler) mySchemaErrorHandler).isError()) {
        throw new Exception("Validation Error");
    }
}

/**
 *
 * @param baseSchemaFilePath
 * @return
 * @throws java.lang.Exception
 *
 */
protected Schema createSchema(String baseSchemaFilePath) throws Exception {

    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    LSResourceResolver resourceResolver = (LSResourceResolver) new LocalSchemaLSResourceResolver();
    factory.setResourceResolver(resourceResolver);
    Schema schema = factory.newSchema(new File(baseSchemaFilePath));

    return schema;
}