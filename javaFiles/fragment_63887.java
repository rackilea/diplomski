SchemaFactory schemafac =
     SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
     Schema schema = schemafac.newSchema(new File("myschema.xsd"));
     XMLReaderJDOMFactory factory = new XMLReaderSchemaFactory(schema);
     SAXBuilder sb = new SAXBuilder(factory);
     Document doc = sb.build(new File("file.xml"));