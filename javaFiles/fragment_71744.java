XMLInputFactory xif = XMLInputFactory.newFactory();
xif.setXMLResolver(new XMLResolver() {
  @Override
  public Object resolveEntity(String publicID, String systemID, String baseURI, String namespace) throws XMLStreamException {
    try {
      if ("onlineDoc.dtd".equals(systemID))
        return new ClassPathResource(systemID, getClass()).getInputStream();
    }
    catch (IOException e) {
      return null;
    }
    return null;
  }
});
XMLStreamReader reader = xif.createXMLStreamReader(new ClassPathResource("a.xml", this.getClass()).getInputStream());
while (reader.hasNext()) {
  reader.next();
  if (reader.isCharacters())
    log.info(new String(reader.getTextCharacters()));
}