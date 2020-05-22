javax.xml.validation.SchemaFactory schemaFactory = SchemaFactory
        .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

schemaFactory
    .setFeature(
        "http://apache.org/xml/features/validation/schema-full-checking",
        false);