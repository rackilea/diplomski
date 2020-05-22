class CustomParsingEmbeddedDocumentExtractor extends ParsingEmbeddedDocumentExtractor {
  public CustomParsingEmbeddedDocumentExtractor(ParseContext context) {
    super(context);
  }

  public void parseEmbedded(
        InputStream stream, ContentHandler handler, Metadata metadata, boolean outputHtml)
        throws SAXException, IOException {


    String name = metadata.get(Metadata.RESOURCE_NAME_KEY);
    if (name != null && name.length() > 0 ) {
        handler.startElement(XHTML, "h1", "h1", new AttributesImpl());
        char[] chars = name.toCharArray();
        handler.characters(chars, 0, chars.length);
        handler.endElement(XHTML, "h1", "h1");
    }

    //Removed the parsing logic here.. We just want the file names..

  }
}