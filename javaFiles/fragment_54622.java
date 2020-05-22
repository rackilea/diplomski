public String parseToHTML() throws IOException, SAXException, TikaException {
  ContentHandler handler = new ToXMLContentHandler();

  AutoDetectParser parser = new AutoDetectParser();
  Metadata metadata = new Metadata();
  try (InputStream stream = ContentHandlerExample.class.getResourceAsStream("test.doc")) {
    parser.parse(stream, handler, metadata);
    return handler.toString();
  }
}