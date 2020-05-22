private static AutoModel unmarshal(String file) throws Exception {
    JAXBContext context = JAXBContext.newInstance(AutoModel.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = factory.newSchema(new File("src/table/autos.xsd"));
    unmarshaller.setSchema(schema);
    AutoModel model = (AutoModel)unmarshaller.unmarshal(new File(file));
    return model;
}